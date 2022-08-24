package com.belyuk.shop.entity.service;

import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/** The interface User service. */
public interface UserService {
  /**
   * Login user boolean.
   *
   * @param login the login
   * @param password the password
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean login(String login, String password) throws ServiceException;

  /**
   * Register user boolean.
   *
   * @param lastName the last name
   * @param name the name
   * @param password the password
   * @param eMail the e mail
   * @param phoneNumber the phone number
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean registerUser(
      String lastName, String name, String password, String eMail, String phoneNumber)
      throws ServiceException;

  /**
   * Find all users list.
   *
   * @return the list
   * @throws ServiceException the service exception
   */
  List<User> findAllUsers() throws ServiceException;

  /**
   * Delete user boolean.
   *
   * @param id the user id
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean deleteUser(int id) throws ServiceException;

  /**
   * Update user boolean.
   *
   * @param id the id
   * @param userRole the user role
   * @param lastName the last name
   * @param name the name
   * @param password the password
   * @param eMail the e mail
   * @param phoneNumber the phone number
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean updateUser(
      int id,
      UserRole userRole,
      String lastName,
      String name,
      String password,
      String eMail,
      String phoneNumber)
      throws ServiceException;

  /**
   * Find user by id user.
   *
   * @param id the id
   * @return the user
   * @throws ServiceException the service exception
   */
  Optional<User> findUserById(int id) throws ServiceException;

  /**
   * Find user by email boolean.
   *
   * @param email the email
   * @return the boolean
   * @throws ServiceException the service exception
   */
  boolean checkByEmailIfUserExist(String email) throws ServiceException;
}
