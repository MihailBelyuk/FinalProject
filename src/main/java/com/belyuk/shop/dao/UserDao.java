package com.belyuk.shop.dao;

import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.DaoException;

public interface UserDao extends BaseDao<User> {
  boolean authenticate(String login, String password) throws DaoException;
  User find(int id) throws DaoException;
}