package com.belyuk.shop.service;

import com.belyuk.shop.entity.BrandName;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {
  boolean addItem( // TODO: 7/12/2022 a
      String name,
      BrandName brandName,
      ItemCategory itemCategory,
      BigDecimal price,
      boolean inStock)
      throws ServiceException;

  List<Item> findAllItems() throws ServiceException;

  boolean deleteItem(Item item) throws ServiceException;

  boolean updateItem( // TODO: 7/12/2022 a
      int id,
      String name,
      BrandName brandName,
      ItemCategory itemCategory,
      BigDecimal price,
      boolean inStock)
      throws ServiceException;

  User findItemById(int id) throws ServiceException;
}
