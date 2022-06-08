package com.belyuk.shop.controller.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionAttributeListenerImpl implements HttpSessionAttributeListener {
  private static final Logger logger = LogManager.getLogger();
  @Override
  public void attributeAdded(HttpSessionBindingEvent sbe) {
    logger.log(Level.INFO, "+++++Attribute added: "+ sbe.getSession().getAttribute("user_name"));
    logger.log(Level.INFO, "+++++Attribute added: "+ sbe.getSession().getAttribute("current_page"));
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent sbe) {
    /* This method is called when an attribute is removed from a session. */
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent sbe) {
    logger.log(Level.INFO, "=====Attribute replaced: "+ sbe.getSession().getAttribute("user_name"));
    logger.log(Level.INFO, "=====Attribute replaced: "+ sbe.getSession().getAttribute("current_page"));
  }
}
