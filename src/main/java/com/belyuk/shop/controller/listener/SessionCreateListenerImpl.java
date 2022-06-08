package com.belyuk.shop.controller.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionCreateListenerImpl implements HttpSessionListener {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    logger.log(Level.INFO, "Session is created: " + se.getSession().getId());
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    logger.log(Level.INFO, "Session stopped: " + se.getSession().getId());
  }
}
