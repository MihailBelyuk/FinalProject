package com.belyuk.shop.command.impl.admin;

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

import java.util.List;

import static com.belyuk.shop.command.constant.PagePath.USERS_PAGE;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;

public class ShowAllUsersCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getUserService();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    session.setAttribute(CURRENT_PAGE, USERS_PAGE);
    List<User> userList;
    try {
      userList = userService.findAllUsers();
      session.setAttribute(ALL_USERS, userList);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Show all users command failed", e);
      throw new CommandException("Show all users command failed", e);
    }
    return new Router(USERS_PAGE, REDIRECT);
  }
}
