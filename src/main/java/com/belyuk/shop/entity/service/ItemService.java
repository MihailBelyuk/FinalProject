package com.belyuk.shop.entity.service;

import com.belyuk.shop.entity.Brand;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/** The interface Item service. */
public interface ItemService {
  /**
   * Adds new item to the database boolean.
   *
   * @param itemCategory the item category
   * @param brandName the brand name
   * @param picture the picture
   * @param name the name
   * @param description the description
   * @param price the price
   * @param inStock the in stock
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean addItem(
      ItemCategory itemCategory,
      String brandName,
      byte[] picture,
      String name,
      String description,
      BigDecimal price,
      boolean inStock)
      throws ServiceException;

  /**
   * Creates the list of all items stored in the database .
   *
   * @return the list
   * @throws ServiceException the service exception
   */
  List<Item> findAllItems() throws ServiceException;

  /**
   * Deletes the item from the database boolean.
   *
   * @param item the item
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean deleteItem(Item item) throws ServiceException;

  /**
   * Updates item information in the database boolean.
   *
   * @param id the id
   * @param name the name
   * @param brandName the brand name
   * @param itemCategory the item category
   * @param price the price
   * @param inStock the in stock
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean updateItem(
      int id,
      String name,
      Brand brandName,
      ItemCategory itemCategory,
      BigDecimal price,
      boolean inStock)
      throws ServiceException;
  /**
   * Finds item by parameter.
   *
   * @param name the parameter of an item.
   * @return the item
   * @throws ServiceException the service exception
   */
  List<Item> findItemByName(String name) throws ServiceException;
}
