package com.belyuk.shop.dao;

import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.DaoException;

import java.util.Optional;

/** The interface User dao. */
public interface UserDao extends BaseDao<User> {
  /**
   * Authenticates user boolean.
   *
   * @param login the user login
   * @param password the user password
   * @return the boolean
   * @throws DaoException the dao exception
   */
  boolean authenticate(String login, String password) throws DaoException;
  /**
   * Checks if e_mail exists boolean.
   *
   * @param email the user email
   * @return the boolean
   * @throws DaoException the dao exception
   */
  boolean checkIfEmailExists(String email) throws DaoException;
  /**
   * Find user by id.
   *
   * @param id the user id
   * @return the User
   * @throws DaoException the dao exception
   */
  Optional<User> findById(int id) throws DaoException;
}
