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
import static com.belyuk.shop.command.PagePath.*;
import static com.belyuk.shop.command.Router.RouterType.*;

public class DeleteUserCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    String currentPage = String.valueOf(session.getAttribute("current_page"));
    int id = Integer.parseInt(request.getParameter("userId"));
    User user = new User(id);
    try {
      userService.deleteUser(user);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Delete user command failed.", e);
      throw new CommandException("Delete user command failed.", e);
    }
    return new Router(currentPage, REDIRECT);
  }
}
