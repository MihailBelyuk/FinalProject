package com.belyuk.shop.dao.impl;

import com.belyuk.shop.dao.ItemDao;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.exception.DaoException;
import com.belyuk.shop.pool.ConnectionPool;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.belyuk.shop.dao.ColumnName.*;

public class ItemDaoImpl implements ItemDao {

  private static final Logger logger = LogManager.getLogger();

  private static final String BASE_ENCODER = "data:image/jpg;base64,";
  private static final String PERCENT = "%";
  private static final String ADD_ITEM = "INSERT into items VALUES (?,?,?,?,?,?,?,?)";
  private static final String DELETE_ITEM = "DELETE FROM items WHERE  id_item=?";
  private static final String FIND_ALL_ITEMS =
      "SELECT id_item, item_category, brand, picture, name, description, price, in_stock FROM items";
  private static final String FIND_ITEM_BY_NAME =
      "SELECT picture,name, description, price, in_stock FROM items WHERE name LIKE ?";
  private static final String UPDATE_ITEM =
      "UPDATE items SET item_category=?, brand = ?, picture = ?, name = ?, description = ?, price=?, in_stock=? WHERE id_item=?";
  private static final String FIND_ITEM_BY_ID =
      "SELECT item_category,brand, picture, name, description, price, in_stock FROM items WHERE id_item =?";
  private static final ItemDaoImpl instance = new ItemDaoImpl();
  private final ConnectionPool connectionPool = ConnectionPool.getInstance();

  ItemDaoImpl() {}

  public static ItemDaoImpl getInstance() {
    return instance;
  }

  @Override
  public boolean add(Item item) throws DaoException {
    ByteArrayInputStream picture = new ByteArrayInputStream(item.getImageBytes());
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(ADD_ITEM);
      preparedStatement.setNull(1, Types.INTEGER);
      preparedStatement.setString(2, item.getItemCategory().toString().toLowerCase());
      preparedStatement.setString(3, item.getBrandName());
      preparedStatement.setBlob(4, picture);
      preparedStatement.setString(5, item.getName());
      preparedStatement.setString(6, item.getDescription());
      preparedStatement.setBigDecimal(7, item.getPrice());
      preparedStatement.setBoolean(8, item.isInStock());
      return preparedStatement.execute();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Filed to add item information to DB.", e);
      throw new DaoException("Filed to add item information to DB.", e);
    }
  }

  @Override
  public boolean delete(int id) throws DaoException {
    if (id == 0) {
      logger.log(
          Level.ERROR, "Unable to delete item information from the DB, because item id is 0.");
      throw new DaoException(
          "Unable to delete user information from the DB, because item id is 0.");
    }
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ITEM);
      preparedStatement.setInt(1, id);
      return preparedStatement.execute();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Failed to delete item from DB.", e);
      throw new DaoException("Failed to delete item from DB.", e);
    }
  }

  @Override
  public List<Item> selectAll() throws DaoException {
    List<Item> itemList = new ArrayList<>();
    Item item;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ITEMS);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int itemId = resultSet.getInt(ID_ITEM);
        ItemCategory itemCategory =
            ItemCategory.valueOf(resultSet.getString(ITEM_CATEGORY).toUpperCase());
        String brand = resultSet.getString(BRAND);
        byte[] picture = resultSet.getBlob(PICTURE).getBinaryStream().readAllBytes();
        StringBuilder sb = new StringBuilder(BASE_ENCODER);
        byte[] encodedImage = Base64.encodeBase64(picture, false);
        String imgString = StringUtils.newStringUtf8(encodedImage);
        sb.append(imgString);
        String newImage = sb.toString();
        String name = resultSet.getString(ITEM_NAME);
        String description = resultSet.getString(DESCRIPTION);
        BigDecimal price = resultSet.getBigDecimal(PRICE);
        boolean inStock = resultSet.getBoolean(IN_STOCK);
        item = new Item();
        item.setId(itemId);
        item.setItemCategory(itemCategory);
        item.setBrandName(brand);
        item.setEncodedImage(newImage);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setInStock(inStock);
        itemList.add(item);
      }
    } catch (SQLException | IOException e) {
      logger.log(Level.ERROR, "Failed to form item list from DB.", e);
      throw new DaoException("Failed to form item list from DB.", e);
    }
    return itemList;
  }

  @Override
  public int update(Item item) throws DaoException {
    ByteArrayInputStream picture = new ByteArrayInputStream(item.getImageBytes());
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ITEM);
      preparedStatement.setString(1, item.getItemCategory().toString().toLowerCase());
      preparedStatement.setString(2, item.getBrandName());
      preparedStatement.setBlob(3, picture);
      preparedStatement.setString(4, item.getName());
      preparedStatement.setString(5, item.getDescription());
      preparedStatement.setBigDecimal(6, item.getPrice());
      preparedStatement.setBoolean(7, item.isInStock());
      preparedStatement.setInt(8, item.getId());
      return preparedStatement.executeUpdate();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Failed to update item information.", e);
      throw new DaoException("Failed to update item information.", e);
    }
  }

  @Override
  public Optional<Item> findById(int id) throws DaoException {
    Item item = null;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_ITEM_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        ItemCategory itemCategory =
            ItemCategory.valueOf(resultSet.getString(ITEM_CATEGORY).toUpperCase());
        String brand = resultSet.getString(BRAND);
        byte[] picture = resultSet.getBlob(PICTURE).getBinaryStream().readAllBytes();
        StringBuilder sb = new StringBuilder(BASE_ENCODER);
        byte[] encodedImage = Base64.encodeBase64(picture, false);
        String imgString = StringUtils.newStringUtf8(encodedImage);
        sb.append(imgString);
        String newImage = sb.toString();
        String name = resultSet.getString(ITEM_NAME);
        String description = resultSet.getString(DESCRIPTION);
        BigDecimal price = resultSet.getBigDecimal(PRICE);
        boolean inStock = resultSet.getBoolean(IN_STOCK);
        item = new Item();
        item.setItemCategory(itemCategory);
        item.setBrandName(brand);
        item.setEncodedImage(newImage);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setInStock(inStock);
        item.setId(id);
      }
    } catch (SQLException | IOException e) {
      logger.log(Level.ERROR, "Failed to find item by id.", e);
      throw new DaoException("Failed to find item by id.", e);
    }
    return Optional.ofNullable(item);
  }

  @Override
  public List<Item> findItemsByName(String name) throws DaoException {
    if (name == null) {
      logger.log(Level.ERROR, "Failed to find items by name, because provided name is null.");
      throw new DaoException("Failed to find items by name, because provided name is null.");
    }
    List<Item> items = new ArrayList<>();
    String modifiedName = PERCENT + name + PERCENT;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_ITEM_BY_NAME);
      preparedStatement.setString(1, modifiedName);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        byte[] picture = resultSet.getBlob(PICTURE).getBinaryStream().readAllBytes();
        StringBuilder sb = new StringBuilder(BASE_ENCODER);
        byte[] encodedImage = Base64.encodeBase64(picture, false);
        String imgString = StringUtils.newStringUtf8(encodedImage);
        sb.append(imgString);
        String newImage = sb.toString();
        String nameFromDb = resultSet.getString(ITEM_NAME);
        String description = resultSet.getString(DESCRIPTION);
        BigDecimal price = resultSet.getBigDecimal(PRICE);
        boolean inStock = resultSet.getBoolean(IN_STOCK);
        Item item = new Item();
        item.setName(nameFromDb);
        item.setPrice(price);
        item.setEncodedImage(newImage);
        item.setInStock(inStock);
        item.setDescription(description);
        items.add(item);
      }
    } catch (SQLException | IOException e) {
      logger.log(Level.ERROR, "Failed to find items by name", e);
      throw new DaoException("Failed to find items by name", e);
    }
    return items;
  }
}
