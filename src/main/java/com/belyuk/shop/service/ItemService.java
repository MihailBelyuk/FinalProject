package com.belyuk.shop.service;

import com.belyuk.shop.entity.Brand;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.ServiceException;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

public interface ItemService {
  boolean addItem(
          ItemCategory itemCategory,
          String brandName,
          InputStream picture,
          String name,
          String description,
          BigDecimal price,
          boolean inStock)
      throws ServiceException;

  List<Item> findAllItems() throws ServiceException;

  boolean deleteItem(Item item) throws ServiceException;

  boolean updateItem(
      int id,
      String name,
      Brand brandName,
      ItemCategory itemCategory,
      BigDecimal price,
      boolean inStock)
      throws ServiceException;

  User findItemById(int id) throws ServiceException;
}
