package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.constant.AttributeParameterName.USER_ID_PARAM;

public class DeleteUserCommand implements Command {

  public static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getUserService();

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
