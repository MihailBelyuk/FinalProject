package com.belyuk.shop.entity.service.impl;

import com.belyuk.shop.dao.impl.ItemDaoImpl;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.service.ItemService;
import com.belyuk.shop.exception.DaoException;
import com.belyuk.shop.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {

  private static final Logger logger = LogManager.getLogger();
  private static final ItemServiceImpl instance = new ItemServiceImpl();
  private final ItemDaoImpl itemDao = ItemDaoImpl.getInstance();

  private ItemServiceImpl() {}

  public static ItemServiceImpl getInstance() {
    return instance;
  }

  @Override
  public boolean addItem(
      ItemCategory itemCategory,
      String brandName,
      byte[] picture,
      String name,
      String description,
      BigDecimal price,
      boolean inStock)
      throws ServiceException {
    if (itemCategory == null
        || brandName == null
        || picture == null
        || name == null
        || description == null
        || price == null) {
      logger.log(Level.ERROR, "Failed add item service, because one or more parameters is null.");
      throw new ServiceException(
          "Failed add item service, because one or more parameters is null.");
    }
    Item item = new Item(itemCategory, brandName, picture, name, description, price, inStock);
    try {
      return itemDao.add(item);
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Add item service failed.", e);
      throw new ServiceException("Add item service failed.", e);
    }
  }

  @Override
  public List<Item> findAllItems() throws ServiceException {
    List<Item> items;
    try {
      items = itemDao.selectAll();
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Failed to fulfil 'Find all items' service.", e);
      throw new ServiceException("Failed to fulfil 'Find all items' service.", e);
    }
    return items;
  }

  @Override
  public boolean deleteItem(int id) throws ServiceException {
    if (id == 0) {
      logger.log(Level.ERROR, "Delete item service failed, because item id is 0.");
      throw new ServiceException("Delete item service failed, because item id is 0.");
    }
    boolean deleteItem;
    try {
      deleteItem = itemDao.delete(id);
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Delete item service failed.", e);
      throw new ServiceException("Delete item service failed.", e); // TODO: 8/8/2022a
    }
    return deleteItem;
  }

  @Override
  public boolean updateItem(
      int id,
      ItemCategory itemCategory,
      String brandName,
      byte[] picture,
      String name,
      String description,
      BigDecimal price,
      boolean inStock)
      throws ServiceException {
    if (id == 0
        || itemCategory == null
        || brandName == null
        || picture == null
        || name == null
        || description == null
        || price == null) {
      logger.log(
          Level.ERROR, "Item update service failed, because one or more parameters is null.");
      throw new ServiceException(
          "Item update service failed, because one or more parameters is null.");
    }
    Item item = new Item(id, itemCategory, brandName, picture, name, description, price, inStock);
    try {
      if (itemDao.update(item) == 0) {
        return false;
      }
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Item update service failed.", e);
      throw new ServiceException("Item update service failed.", e);
    }
    return true;
  }

  @Override
  public List<Item> findItemByName(String name) throws ServiceException {
    if (name == null) {
      logger.log(Level.ERROR, "Find item by name service failed, because provided name is null.");
      throw new ServiceException(
          "Find item by name service failed, because provided name is null.");
    }
    List<Item> items;
    try {
      items = itemDao.findItemsByName(name);
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Find item by name service failed", e);
      throw new ServiceException("Find item by name service failed", e);
    }
    return items;
  }

  @Override
  public Optional<Item> findItemById(int id) throws ServiceException {
    if (id == 0) {
      logger.log(Level.ERROR, "Find item by id service failed,because id is 0.");
      throw new ServiceException("Find item by id service failed,because id is 0.");
    }
    Item item;
    try {
      item = itemDao.findById(id).orElseThrow(() -> new ServiceException("Item is null."));
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Find item by id service failed.", e);
      throw new ServiceException("Find item by id service failed.", e);
    }
    return Optional.ofNullable(item);
  }
}
