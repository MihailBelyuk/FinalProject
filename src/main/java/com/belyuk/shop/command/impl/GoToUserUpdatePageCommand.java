package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.AttributeParameterName.*;
import static com.belyuk.shop.command.PagePath.USER_UPDATE_PAGE;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;

public class GoToUserUpdatePageCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  public static final String PASSWORD = "password";
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    User user;
    try {
      user = userService.findUserById(Integer.parseInt(request.getParameter(USER_ID_PARAM)));
      session.setAttribute(USER_ROLE_ATTRIBUTE, user.getUserRole().toString());
      session.setAttribute(LAST_NAME_ATTRIBUTE, user.getLastName());
      session.setAttribute(NAME_ATTRIBUTE, user.getName());
      session.setAttribute(PASSWORD_ATTRIBUTE, PASSWORD);
      session.setAttribute(EMAIL_ATTRIBUTE, user.geteMail());
      session.setAttribute(PHONE_NUMBER_ATTRIBUTE, user.getPhoneNumber());
      session.setAttribute(USER_ID_ATTRIBUTE, request.getParameter(USER_ID_PARAM));
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to find user by ID.", e);
      throw new CommandException("Failed to find user by ID.", e);
    }
    return new Router(USER_UPDATE_PAGE, FORWARD);
  }
}
