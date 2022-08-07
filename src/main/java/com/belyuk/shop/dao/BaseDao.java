package com.belyuk.shop.dao;

import com.belyuk.shop.entity.AbstractEntity;
import com.belyuk.shop.exception.DaoException;

import java.util.List;

/**
 * The interface Base dao.
 *
 * @param <T> the type parameter
 */
public interface BaseDao<T extends AbstractEntity> {
  /**
   * Add boolean.
   *
   * @param t the t
   * @return the boolean
   * @throws DaoException the dao exception
   */
  boolean add(T t) throws DaoException;

  /**
   * Delete boolean.
   *
   * @param t the t
   * @return the boolean
   * @throws DaoException the dao exception
   */
  boolean delete(T t) throws DaoException;

  /**
   * Select all list.
   *
   * @return the list
   * @throws DaoException the dao exception
   */
  List<T> selectAll() throws DaoException;

  /**
   * Update int.
   *
   * @param t the t
   * @return the int
   * @throws DaoException the dao exception
   */
  int update(T t) throws DaoException;
  T findById(int id) throws DaoException;
}
