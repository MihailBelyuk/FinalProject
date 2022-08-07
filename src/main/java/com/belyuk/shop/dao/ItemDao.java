package com.belyuk.shop.dao;


import com.belyuk.shop.entity.Item;
import com.belyuk.shop.exception.DaoException;

import java.util.List;

/** The interface Item dao. */
public interface ItemDao extends BaseDao<Item> {

   List<Item> findItemsByName(String name) throws DaoException;
}
