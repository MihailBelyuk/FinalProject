package com.belyuk.shop.service;

import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.exception.ServiceException;

import java.util.List;

public interface UserService {
  boolean login(String login, String password) throws ServiceException;

  boolean registerUser(
      String lastName, String name, String password, String eMail, String phoneNumber)
      throws ServiceException;

  List<User> findAllUsers() throws ServiceException;

  boolean deleteUser(User user) throws ServiceException;

  boolean updateUser(
      int id,
      UserRole userRole,
      String lastName,
      String name,
      String password,
      String eMail,
      String phoneNumber)
      throws ServiceException;

  User findUserById(int id) throws ServiceException;
}
