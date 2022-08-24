package com.belyuk.shop.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
  private static final Logger logger = LogManager.getLogger();
  private static final String URL = "url";
  private static final String DRIVER = "driver";
  private static final String DB_PROPERTIES = "prop/db.properties";
  private static final Properties dbProperties = new Properties();
  private static final ReentrantLock lock = new ReentrantLock();
  private static final AtomicBoolean isCreate = new AtomicBoolean(false);
  private static final int DEFAULT_POOL_SIZE = 8;
  private static ConnectionPool instance;
  private final BlockingQueue<ProxyConnection> freeConnections;
  private final BlockingQueue<ProxyConnection> usedConnections;

  {
    freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
    usedConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DB_PROPERTIES)) {
      dbProperties.load(inputStream);
      Class.forName(dbProperties.getProperty(DRIVER));
    } catch (ClassNotFoundException | IOException e) {
      logger.log(Level.ERROR, "Failed to register driver", e);
      throw new ExceptionInInitializerError(e.getMessage());
    }
  }

  private ConnectionPool() {
    for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
      Connection connection;

      try {
        connection = DriverManager.getConnection(dbProperties.getProperty(URL), dbProperties);
        ProxyConnection proxyConnection = new ProxyConnection(connection);
        freeConnections.add(proxyConnection);
      } catch (SQLException e) {
        logger.log(Level.ERROR, "Failed to establish connection.", e);
        throw new ExceptionInInitializerError(e.getMessage());
      }
    }
  }

  public static ConnectionPool getInstance() {
    if (!isCreate.get()) {
      lock.lock();
      try {
        if (instance == null) {
          instance = new ConnectionPool();
          isCreate.set(true);
        }
      } finally {
        lock.unlock();
      }
    }
    return instance;
  }

  public Connection getConnection() {
    ProxyConnection proxyConnection = null;
    try {
      proxyConnection = freeConnections.take();
      usedConnections.put(proxyConnection);
    } catch (InterruptedException e) {
      logger.log(Level.ERROR, "Failed to put used connection.", e);
      Thread.currentThread().interrupt();
    }
    return proxyConnection;
  }

  public boolean releaseConnection(Connection connection) {
    if (!(connection instanceof ProxyConnection proxyConnection)) {
      return false;
    }
    usedConnections.remove(proxyConnection);
    try {
      freeConnections.put(proxyConnection);
    } catch (InterruptedException e) {
      logger.log(Level.ERROR, "Failed to put free connection.", e);
      Thread.currentThread().interrupt();
    }
    return true;
  }

  public void destroyPool() {
    for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
      try {
        freeConnections.take().reallyClose();
      } catch (InterruptedException e) {
        logger.log(Level.WARN, "Unable to close connection.", e);
        Thread.currentThread().interrupt();
      }
    }
    deregisterDriver();
  }

  private void deregisterDriver() {
    Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
    while (drivers.hasMoreElements()) {
      java.sql.Driver driver = drivers.nextElement();
      try {
        DriverManager.deregisterDriver(driver);
      } catch (SQLException e) {
        logger.log(Level.ERROR, "Failed to deregister driver", e);
      }
    }
  }
}
