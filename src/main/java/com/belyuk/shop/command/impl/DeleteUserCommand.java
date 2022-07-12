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

import static com.belyuk.shop.command.AttributeParameterName.CURRENT_PAGE;
import static com.belyuk.shop.command.AttributeParameterName.USER_ID_PARAM;

public class DeleteUserCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    int id = Integer.parseInt(request.getParameter(USER_ID_PARAM));
    User user = new User(id);
    try {
      userService.deleteUser(user);
      return new ShowAllUsersCommand().execute(request);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Delete user command failed.", e);
      throw new CommandException("Delete user command failed.", e);
    }
  }
}
