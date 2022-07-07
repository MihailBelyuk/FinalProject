package com.belyuk.shop.dao;

import com.belyuk.shop.entity.AbstractEntity;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.DaoException;

import java.util.List;

public interface BaseDao<T extends AbstractEntity> {
  boolean add(T t) throws DaoException;

  boolean delete(T t) throws DaoException;

  List<T> selectAll() throws DaoException;

  int update(T t) throws DaoException;

}
