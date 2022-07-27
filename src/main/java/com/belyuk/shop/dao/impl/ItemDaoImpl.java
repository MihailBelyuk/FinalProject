package com.belyuk.shop.dao.impl;

import com.belyuk.shop.dao.ItemDao;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
  public static final String ADD_ITEM = "INSERT into item VALUES (?,?,?,?,?,?,?,?)";
  private static final ItemDaoImpl instance = new ItemDaoImpl();
  private final ConnectionPool connectionPool = ConnectionPool.getInstance();

  ItemDaoImpl() {}

  public static ItemDaoImpl getInstance() {
    return instance;
  }

  @Override
  public boolean add(Item item) {
    Connection connection;
    PreparedStatement preparedStatement;
    try {
      connection = connectionPool.getConnection();
      preparedStatement = connection.prepareStatement(ADD_ITEM);
      preparedStatement.setNull(1, Types.INTEGER);
      preparedStatement.setString(2, item.getItemCategory().toString().toLowerCase());
      preparedStatement.setString(3, item.getBrandName());
      preparedStatement.setBlob(4, item.getPicture());
      preparedStatement.setString(5, item.getName());
      preparedStatement.setString(6, item.getDescription());
      preparedStatement.setBigDecimal(7, item.getPrice());
      preparedStatement.setBoolean(8, item.isInStock());
      preparedStatement.execute();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Item item) {
    return false;
  }

  @Override
  public List<Item> selectAll() {
    return null;
  }

  @Override
  public int update(Item item) {
    return 0;
  }

  @Override
  public Item find(long id) {
    return null;
  }
}
