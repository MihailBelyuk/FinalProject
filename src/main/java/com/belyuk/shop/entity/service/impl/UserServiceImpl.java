package com.belyuk.shop.entity.service.impl;

import com.belyuk.shop.dao.impl.UserDaoImpl;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.entity.service.UserService;
import com.belyuk.shop.exception.DaoException;
import com.belyuk.shop.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {

  private static final UserDaoImpl userDao = UserDaoImpl.getInstance();
  private static final UserServiceImpl userService = new UserServiceImpl();
  private static Logger logger = LogManager.getLogger();
<<<<<<< HEAD:src/main/java/com/belyuk/shop/entity/service/impl/UserServiceImpl.java
=======

>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/service/impl/UserServiceImpl.java

  private UserServiceImpl() {}

  public static UserServiceImpl getUserService() {
    return userService;
  }

  @Override
  public boolean login(String login, String password) throws ServiceException {
    if (login == null || password == null) {
      logger.log(Level.ERROR, "Provided login or password is null!");
      throw new ServiceException("Provided login or password is null!");
    }
    try {
      return userDao.authenticate(login, password);
    } catch (DaoException e) {
      logger.log(
          Level.ERROR, "User login and password do not match DB stored login and password.", e);
      throw new ServiceException(
          "User login and password do not match DB stored login and password.", e);
    }
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
      logger.log(Level.ERROR, "Failed to register user.", e);
      throw new ServiceException("Failed to register user.", e);
    }
    return addUser;
  }

  @Override
  public List<User> findAllUsers() throws ServiceException {
    List<User> list;
    try {
      list = userDao.selectAll();
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Unable to find all users in DB.");
      throw new ServiceException("Unable to find all users in DB.");
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
      logger.log(Level.ERROR, "Delete user service failed", e);
      throw new ServiceException("Delete user service failed", e);
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
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Update user service failed", e);
      throw new ServiceException("Update user service failed", e);
    }
    return false;
  }

  @Override
  public User findUserById(int id) throws ServiceException {
    if (id == 0) {
      logger.log(Level.ERROR, "Find user by id service failed, because id is '0'");
      throw new ServiceException("Find user by id service failed, because id is '0'");
    }
    User user;
    try {
      user = userDao.findById(id);
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Find user by ID service failed", e);
      throw new ServiceException("Find user by ID service failed", e);
    }
    return user;
  }

  @Override
  public boolean checkByEmailIfUserExist(String email) throws ServiceException {
    if (email == null) {
      logger.log(
          Level.ERROR,
          "Check by e-mail if user exist service failed, because provided e-mail is null");
      throw new ServiceException(
          "Check by e-mail if user exist service failed, because provided e-mail is null");
    }
    try {
      return userDao.checkIfEmailExists(email);
    } catch (DaoException e) {
      logger.log(Level.ERROR, "Find user by email service failed.", e);
      throw new ServiceException("Find user by email service failed.", e);
    }
  }
}
