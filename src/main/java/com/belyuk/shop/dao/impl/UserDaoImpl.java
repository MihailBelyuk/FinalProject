package com.belyuk.shop.dao.impl;

import com.belyuk.shop.dao.ColumnName;
import com.belyuk.shop.dao.UserDao;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserStatus;
import com.belyuk.shop.exception.DaoException;
import com.belyuk.shop.pool.ConnectionPool;
import com.belyuk.shop.util.Utility;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
  private static final Logger logger = LogManager.getLogger();
  private static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM users WHERE e_mail =?";
  private static final String ADD_USER_STATEMENT = "INSERT INTO users VALUES (?,?,?,?,?,?,?)";
  private static final String FIND_ALL_USERS =
      "SELECT id, status, last_name, name, password, e_mail, phone_number FROM users";
  private static UserDaoImpl instance = new UserDaoImpl();

  private UserDaoImpl() {}

  public static UserDaoImpl getInstance() {
    return instance;
  }

  @Override
  public boolean add(User user) throws DaoException {
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_STATEMENT);
      String hashPassword = Utility.getInstance().encodePassword(user.getPassword());
      preparedStatement.setNull(1, Types.INTEGER);
      preparedStatement.setString(2, user.getUserStatus().toString().toLowerCase());
      preparedStatement.setString(3, user.getLastName());
      preparedStatement.setString(4, user.getName());
      preparedStatement.setString(5, hashPassword);
      preparedStatement.setString(6, user.geteMail());
      preparedStatement.setString(7, user.getPhoneNumber());
      return preparedStatement.execute();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Failed to insert user data into database.", e);
      throw new DaoException("Failed to insert user data into database.", e);
    }
  }

  @Override
  public boolean delete(User user) {
    return false;
  }

  @Override
  public List<User> selectAll() throws DaoException {
    List<User> userList = new ArrayList<>();
    User user;
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS);
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()){
        String id= resultSet.getString(1);
        String status = resultSet.getString(2).toUpperCase();
        String lastName = resultSet.getString(3);
        String name = resultSet.getString(4);
        String password = resultSet.getString(5);
        String eMail = resultSet.getString(6);
        String phoneNumber = resultSet.getString(7);
        user = new User();
        user.setUserId(Integer.parseInt(id));
        user.setUserStatus(UserStatus.valueOf(status));
        user.setLastName(lastName);
        user.setName(name);
        user.setPassword(password);
        user.seteMail(eMail);
        user.setPhoneNumber(phoneNumber);
        userList.add(user);
      }
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Unable to extract all users from DB.");
      throw new DaoException("Unable to extract all users from DB.", e);
    }
    return userList;
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public boolean authenticate(String login, String password) throws DaoException {
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    boolean match = false;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_PASSWORD);
      preparedStatement.setString(1, login);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        String passFromDb = resultSet.getString(ColumnName.PASSWORD);
        match = password.equals(passFromDb);
      }
    } catch (SQLException e) {
      logger.log(Level.WARN, "Provided password does not match DB stored password.", e);
      throw new DaoException("Provided password does not match DB stored password.", e);
    }
    return match;
  }
}
