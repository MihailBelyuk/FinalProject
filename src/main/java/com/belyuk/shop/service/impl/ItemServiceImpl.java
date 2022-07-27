package com.belyuk.shop.service.impl;

import com.belyuk.shop.dao.impl.ItemDaoImpl;
import com.belyuk.shop.entity.Brand;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.ItemService;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class ItemServiceImpl implements ItemService {
  private static final ItemServiceImpl instance = new ItemServiceImpl();
  private ItemDaoImpl itemDao = ItemDaoImpl.getInstance();

  private ItemServiceImpl() {}

  public static ItemServiceImpl getInstance() {
    return instance;
  }

  @Override
  public boolean addItem(
      ItemCategory itemCategory,
      String brandName,
      InputStream picture,
      String name,
      String description,
      BigDecimal price,
      boolean inStock)
      throws ServiceException {

    Item item = new Item(itemCategory, brandName, picture, name, description, price, inStock);
    return itemDao.add(item);
  }

  @Override
  public List<Item> findAllItems() throws ServiceException {
    return null;
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
  public User findItemById(int id) throws ServiceException {
    return null;
  }
}
