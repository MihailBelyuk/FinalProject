package com.belyuk.shop.dao;


import com.belyuk.shop.entity.Item;
import com.belyuk.shop.exception.DaoException;

public interface ItemDao extends BaseDao<Item> {
    Item find(long id) throws DaoException;
}
