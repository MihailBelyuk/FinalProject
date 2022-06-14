package com.belyuk.shop.service.impl;

import com.belyuk.shop.dao.impl.UserDaoImpl;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.DaoException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.UserService;
import com.belyuk.shop.service.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
  private static final UserDaoImpl userDao = UserDaoImpl.getInstance();
  private static Logger logger = LogManager.getLogger();
  private static UserServiceImpl instance = new UserServiceImpl();

  private UserServiceImpl() {}

  public static UserServiceImpl getInstance() {
    return instance;
  }

  @Override
  public boolean login(String login, String password) throws ServiceException {
    if (login == null || password == null) {
      logger.log(Level.ERROR, "Provided login or password is null!");
      throw new ServiceException("Provided login or password is null!");
    }
    boolean validLogin = UserValidatorImpl.getInstance().validateLogin(login);
    boolean validPassword = UserValidatorImpl.getInstance().validatePassword(password);
    if (validLogin && validPassword) {
      try {
        userDao.authenticate(login, password);
      } catch (DaoException e) {
        logger.log(
            Level.ERROR, "User login and password do not match DB stored login and password.", e);
        throw new ServiceException(
            "User login and password do not match DB stored login and password.", e);
      }
      return true;
    }
    return false;
  }

  @Override
  public boolean registerUser(User user) throws ServiceException {
    if (user == null) {
      logger.log(Level.ERROR, "User information is null!");
      throw new ServiceException("User information is null!");
    }
    boolean addUser;
    try {
      addUser = userDao.add(user);
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Failed to add user data into DB.", e);
      throw new ServiceException(e);
    }
    return addUser;
  }

  @Override
  public List<User> findAllUsers() throws ServiceException {
    List<User> list;
    try {
      list = userDao.selectAll();
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Unable to find users in DB.");
      throw new ServiceException("Unable to find users in DB.");
    }
    return list;
  }
}
