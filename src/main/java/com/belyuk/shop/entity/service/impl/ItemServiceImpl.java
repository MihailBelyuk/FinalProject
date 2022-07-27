package com.belyuk.shop.entity.service.impl;

import com.belyuk.shop.dao.impl.ItemDaoImpl;
import com.belyuk.shop.entity.Brand;
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
  public boolean deleteItem(Item item) throws ServiceException {
    return false;
  }

  @Override
  public boolean updateItem(
      int id,
      String name,
      Brand brandName,
      ItemCategory itemCategory,
      BigDecimal price,
      boolean inStock)
      throws ServiceException {
    return false;
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
}
