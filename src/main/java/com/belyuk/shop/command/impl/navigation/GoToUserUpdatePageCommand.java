package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

<<<<<<< HEAD
=======
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.PagePath.USER_UPDATE_PAGE;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.PagePath.USER_UPDATE_PAGE;

public class GoToUserUpdatePageCommand implements Command {

  public static final Logger logger = LogManager.getLogger();
  public static final String PASSWORD = "password";
  private UserServiceImpl userService = UserServiceImpl.getUserService();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    User user;
    try {
      user = userService.findUserById(Integer.parseInt(request.getParameter(USER_ID_PARAM)));
      session.setAttribute(USER_ROLE_ATTR, user.getUserRole().toString());
      session.setAttribute(LAST_NAME_ATTR, user.getLastName());
      session.setAttribute(NAME_ATTR, user.getName());
      session.setAttribute(PASSWORD_ATTR, PASSWORD);
      session.setAttribute(EMAIL_ATTR, user.geteMail());
      session.setAttribute(PHONE_NUMBER_ATTR, user.getPhoneNumber());
      session.setAttribute(USER_ID_ATTR, request.getParameter(USER_ID_PARAM));
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to find user by ID.", e);
      throw new CommandException("Failed to find user by ID.", e);
    }
    return new Router(USER_UPDATE_PAGE, FORWARD);
  }
}
