package com.belyuk.shop.dao.impl;

import com.belyuk.shop.dao.ColumnName;
import com.belyuk.shop.dao.UserDao;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.exception.DaoException;
import com.belyuk.shop.pool.ConnectionPool;
import com.belyuk.shop.util.Utility;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
  private static final Logger logger = LogManager.getLogger();
  private static final String SELECT_LOGIN_PASSWORD =
      "SELECT password, user_role FROM users WHERE e_mail =?";
  private static final String ADD_USER_STATEMENT = "INSERT INTO users VALUES (?,?,?,?,?,?,?)";
  private static final String FIND_ALL_USERS =
      "SELECT id, user_role, last_name, name, e_mail, phone_number FROM users";
  private static final String DELETE_USER = "DELETE FROM users WHERE  id=?";
  private static final String UPDATE_USER =
      "UPDATE users SET user_role=?, last_name = ?, name = ?, password = ?, e_mail = ?, phone_number=? WHERE id=?";
  private static final String FIND_USER =
      "SELECT user_role,last_name, name, password, e_mail, phone_number FROM users WHERE id =?";

  private static UserDaoImpl instance = new UserDaoImpl();
  private ConnectionPool connectionPool = ConnectionPool.getInstance();
  private Utility utility =Utility.getInstance();

  private UserDaoImpl() {}

  public static UserDaoImpl getInstance() {
    return instance;
  }

  @Override
  public boolean add(User user) throws DaoException { // todo null check everywhere
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_STATEMENT);
      String hashPassword = Utility.getInstance().encodePassword(user.getPassword());
      preparedStatement.setNull(1, Types.INTEGER);
      preparedStatement.setString(2, user.getUserRole().toString().toLowerCase());
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
  public boolean delete(User user) throws DaoException {
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
      preparedStatement.setInt(1, user.getId());
      return preparedStatement.execute();
    } catch (SQLException e) { // TODO: exception and log
      throw new DaoException();
    }
  }

  @Override
  public List<User> selectAll() throws DaoException {
    List<User> userList = new ArrayList<>();
    User user;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String id = resultSet.getString(1);
        String userRole = resultSet.getString(2).toUpperCase();
        String lastName = resultSet.getString(3);
        String name = resultSet.getString(4);
        String eMail = resultSet.getString(5);
        String phoneNumber = resultSet.getString(6);
        user = new User();
        user.setId(Integer.parseInt(id));
        user.setUserRole(UserRole.valueOf(userRole));
        user.setLastName(lastName);
        user.setName(name);
        user.seteMail(eMail);
        user.setPhoneNumber(phoneNumber);
        userList.add(user);
      }
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Unable to extract all users from DB.", e);
      throw new DaoException("Unable to extract all users from DB.", e);
    }
    return userList;
  }

  @Override
  public int update(User user) throws DaoException {
    String hashPassword=utility.encodePassword(user.getPassword());
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
      preparedStatement.setString(1,String.valueOf(user.getUserRole()).toLowerCase());
      preparedStatement.setString(2, user.getLastName());
      preparedStatement.setString(3, user.getName());
      preparedStatement.setString(4, hashPassword);
      preparedStatement.setString(5, user.geteMail());
      preparedStatement.setString(6, user.getPhoneNumber());
      preparedStatement.setInt(7,user.getId());
      return preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException(e); // TODO: log and exception;
    }
  }

  @Override
  public boolean authenticate(String login, String password) throws DaoException {
    String hashPassword = utility.encodePassword(password);
    boolean match = false;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_PASSWORD);
      preparedStatement.setString(1, login);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        String passFromDb = resultSet.getString(ColumnName.PASSWORD);
        match = hashPassword.equals(passFromDb);
      }
    } catch (SQLException e) {
      logger.log(Level.WARN, "Provided password does not match DB stored password.", e);
      throw new DaoException("Provided password does not match DB stored password.", e);
    }
    return match;
  }

  @Override
  public User find(int id) throws DaoException {
    User user = null;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
      preparedStatement.setInt(1,id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        UserRole userRole = UserRole.valueOf(resultSet.getString("user_role").toUpperCase());
        String lastName = resultSet.getString("last_name");
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");
        String e_mail = resultSet.getString("e_mail");
        String phoneNumber = resultSet.getString("phone_number");
        user = new User(userRole, lastName, name, password, e_mail, phoneNumber);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }
}
