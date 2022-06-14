package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.PagePath;
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

public class ShowAllUsersCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    String page = PagePath.EMPTY_PAGE;
    List<User> userList;

    try {
      userList = userService.findAllUsers();
      session.setAttribute("all_users", userList);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Show all users command failed", e);
      throw new CommandException("Show all users command failed", e);
    }
    return new Router(page, Router.RouterType.REDIRECT);
  }
}
