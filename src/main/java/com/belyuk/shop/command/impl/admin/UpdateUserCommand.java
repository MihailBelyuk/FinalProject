package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.constant.AttributeParameterName.*;

public class UpdateUserCommand implements Command {

  private static final Logger logger = LogManager.getLogger();
<<<<<<< HEAD
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
=======
  private UserServiceImpl userService = UserServiceImpl.getUserService();
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    int id = Integer.parseInt((String) session.getAttribute(USER_ID_ATTR));
    UserRole userRole = UserRole.valueOf(request.getParameter(USER_ROLE_PARAM).toUpperCase());
    String lastName = request.getParameter(LAST_NAME_PARAM);
    String name = request.getParameter(NAME_PARAM);
    String password = request.getParameter(PASSWORD_PARAM);
    String eMail = request.getParameter(EMAIL_PARAM);
    String phoneNumber = request.getParameter(PHONE_NUMBER_PARAM);
    try {
      userService.updateUser(id, userRole, lastName, name, password, eMail, phoneNumber);
      return new ShowAllUsersCommand().execute(request);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to update user.", e);
      throw new CommandException("Failed to update user.", e);
    }
  }
}
