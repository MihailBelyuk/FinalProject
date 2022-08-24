package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.INCORRECT_LOGIN_OR_PASSWORD_MSG;
import static com.belyuk.shop.command.constant.PagePath.*;

public class LoginCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private static final String LOGOUT = "Logout";
  private final UserServiceImpl userService = UserServiceImpl.getUserService();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String eMail = request.getParameter(EMAIL_ATTR);
    String password = request.getParameter(PASSWORD_ATTR);
    String page = null;
    HttpSession session = request.getSession();
    try {
      if (userService.login(eMail, password)) {
        List<User> users = UserServiceImpl.getUserService().findAllUsers();
        for (User user : users) {
          if (user.geteMail().equals(eMail)) {
            UserRole status = user.getUserRole();
            page = switch (status) {
              case ADMIN -> ADMIN_PAGE;
              case CLIENT -> CLIENT_PAGE;
            };
            session.setAttribute(LOGGED_USER_PAGE_ATTR, page);
          }
        }
        session.setAttribute(LOGGED_USER_ATTR, eMail);
        session.setAttribute(LOGOUT_ATTR, LOGOUT);
      } else {
        page = LOGIN_PAGE;
        session.setAttribute(LOGIN_MSG_ATTR, INCORRECT_LOGIN_OR_PASSWORD_MSG);
      }
    } catch (ServiceException e) {
      logger.log(Level.WARN, "Authentication failed.", e);
      throw new CommandException("Authentication failed.", e);
    }
    return new Router(page, REDIRECT);
  }
}
