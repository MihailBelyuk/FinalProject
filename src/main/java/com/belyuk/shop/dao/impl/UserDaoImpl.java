package com.belyuk.shop.dao.impl;

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
import java.util.Optional;

import static com.belyuk.shop.dao.ColumnName.*;

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
  private static final String FIND_USER_BY_ID =
      "SELECT user_role,last_name, name, password, e_mail, phone_number FROM users WHERE id =?";
  private static final String FIND_USER_BY_E_MAIL = "SELECT * FROM users WHERE e_mail=?";
  private static final UserDaoImpl instance = new UserDaoImpl();
  private final ConnectionPool connectionPool = ConnectionPool.getInstance();
  private final Utility utility = Utility.getInstance();

  private UserDaoImpl() {}

  public static UserDaoImpl getInstance() {
    return instance;
  }

  @Override
  public boolean add(User user) throws DaoException {
    if (user == null) {
      logger.log(Level.ERROR, "Unable to add user information to the DB, because user is null.");
      throw new DaoException("Unable to add user information to the DB, because user is null.");
    }
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
  public boolean delete(int id) throws DaoException {
    if (id == 0) {
      logger.log(
          Level.ERROR, "Unable to delete user information from the DB, because user id is 0.");
      throw new DaoException(
          "Unable to delete user information from the DB, because user id is 0.");
    }
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
      preparedStatement.setInt(1, id);
      return preparedStatement.execute();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Failed to delete user from DB.", e);
      throw new DaoException("Failed to delete user from DB.", e);
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
    if (user == null) {
      logger.log(
          Level.ERROR, "Unable to update  user information in the DB, because user is null.");
      throw new DaoException("Unable to update  user information in the DB, because user is null.");
    }
    String hashPassword = utility.encodePassword(user.getPassword());
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
      preparedStatement.setString(1, String.valueOf(user.getUserRole()).toLowerCase());
      preparedStatement.setString(2, user.getLastName());
      preparedStatement.setString(3, user.getName());
      preparedStatement.setString(4, hashPassword);
      preparedStatement.setString(5, user.geteMail());
      preparedStatement.setString(6, user.getPhoneNumber());
      preparedStatement.setInt(7, user.getId());
      return preparedStatement.executeUpdate();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Failed to update user information in the DB.", e);
      throw new DaoException("Failed to update user information in the DB.", e);
    }
  }

  @Override
  public boolean authenticate(String login, String password) throws DaoException {
    if (login == null || password == null) {
      logger.log(Level.ERROR, "Failed to authenticate because one or more parameters is null");
      throw new DaoException("Failed to authenticate because one or more parameters is null");
    }
    String hashPassword = utility.encodePassword(password);
    boolean match = false;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_PASSWORD);
      preparedStatement.setString(1, login);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        String passFromDb = resultSet.getString(PASSWORD);
        match = hashPassword.equals(passFromDb);
      }
    } catch (SQLException e) {
      logger.log(Level.WARN, "Provided password does not match DB stored password.", e);
      throw new DaoException("Provided password does not match DB stored password.", e);
    }
    return match;
  }

  @Override
  public Optional<User> findById(int id) throws DaoException {
    if (id == 0) {
      logger.log(Level.ERROR, "Failed to find user by id, because id is 0.");
      throw new DaoException("Failed to find user by id, because id is 0.");
    }
    User user = null;
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        UserRole userRole = UserRole.valueOf(resultSet.getString(USER_ROLE).toUpperCase());
        String lastName = resultSet.getString(LAST_NAME);
        String name = resultSet.getString(NAME);
        String password = resultSet.getString(PASSWORD);
        String e_mail = resultSet.getString(E_MAIL);
        String phoneNumber = resultSet.getString(PHONE_NUMBER);
        user = new User(userRole, lastName, name, password, e_mail, phoneNumber);
      }
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Unable to find user with " + id, e);
      throw new DaoException("Unable to find user by " + id, e);
    }
    return Optional.ofNullable(user);
  }

  @Override
  public boolean checkIfEmailExists(String email) throws DaoException {
    if (email == null) {
      logger.log(Level.ERROR, "Unable to find by email, because email is null.");
      throw new DaoException("Unable to find by email, because email is null.");
    }
    try (Connection connection = connectionPool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_E_MAIL);
      preparedStatement.setString(1, email);
      ResultSet resultSet = preparedStatement.executeQuery();
      return resultSet.next();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "Failed to receive e-mail address from DB.", e);
      throw new DaoException("Failed to receive e-mail address from DB.", e);
    }
  }
}
