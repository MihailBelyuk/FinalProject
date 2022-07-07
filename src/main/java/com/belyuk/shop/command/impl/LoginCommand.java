package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.AttributeParameterName;
import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.belyuk.shop.command.PagePath.*;
import static com.belyuk.shop.command.Router.RouterType.*;

public class LoginCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String eMail = request.getParameter(AttributeParameterName.EMAIL_ATTRIBUTE);
    String password = request.getParameter(AttributeParameterName.PASSWORD_ATTRIBUTE);
    String page = null;
    HttpSession session = request.getSession();
        try {
      if (userService.login(eMail, password)) {
        List<User> users = UserServiceImpl.getInstance().findAllUsers();
        for (User user : users) {
          if (user.geteMail().equals(eMail)) {
            UserRole status = user.getUserRole();
            switch (status) {
              case ADMIN:
                page = ADMIN_PAGE;
                break;
              case CLIENT:
                page = MAIN_PAGE_PATH;
                break;
            }
          }
        }
        session.setAttribute("logged_user", eMail);
      } else {
        page = LOGIN_PAGE_PATH;
        session.setAttribute("login_msg", "Incorrect login or password");
      }
    } catch (ServiceException e) {
      logger.log(Level.WARN, "Authentication failed.", e);
      throw new CommandException("Authentication failed.", e);
    }
    return new Router(page, REDIRECT);
  }
}
