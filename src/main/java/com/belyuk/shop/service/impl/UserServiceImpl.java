package com.belyuk.shop.service.impl;

import com.belyuk.shop.dao.impl.UserDaoImpl;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
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
  public boolean registerUser(
      String lastName, String name, String password, String eMail, String phoneNumber)
      throws ServiceException {
    if (lastName == null
        || name == null
        || password == null
        || eMail == null
        || phoneNumber == null) {
      logger.log(Level.ERROR, "User information is null in user register service.");
      throw new ServiceException("User information is null in user register service.");
    }
    User user = new User();
    user.setLastName(lastName);
    user.setName(name);
    user.setPassword(password);
    user.seteMail(eMail);
    user.setPhoneNumber(phoneNumber);

    user.setUserRole(UserRole.CLIENT);
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

  public boolean deleteUser(User user) throws ServiceException {
    if (user == null) {
      logger.log(Level.ERROR, "Unable to delete user, because user provided user is null.");
      throw new ServiceException("Unable to delete user, because user provided user is null.");
    }
    boolean deleteUser;
    try {
      deleteUser = userDao.delete(user);
    } catch (DaoException e) {
      logger.log(Level.ERROR, e); // TODO: exception/ logger
      throw new ServiceException();
    }
    return deleteUser;
  }

  @Override
  public boolean updateUser(
      int id,
      UserRole userRole,
      String lastName,
      String name,
      String password,
      String eMail,
      String phoneNumber)
      throws ServiceException {
    if (id == 0
        || userRole == null
        || lastName == null
        || name == null
        || password == null
        || eMail == null
        || phoneNumber == null) {
      logger.log(Level.ERROR, "User information is null in user update service.");
      throw new ServiceException("User information is null in user update service.");
    }
    User user = new User();
    user.setId(id);
    user.setUserRole(userRole);
    user.setLastName(lastName);
    user.setName(name);
    user.setPassword(password);
    user.seteMail(eMail);
    user.setPhoneNumber(phoneNumber);
    try {
      userDao.update(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public User findUserById(int id) throws ServiceException {
    if (id == 0) {
      throw new ServiceException("User id can't be '0'");
    }
    User user;
    try {
      user = userDao.find(id);
    } catch (DaoException e) {
      throw new ServiceException(e); // TODO: log and exception
    }
    return user;
  }
}
