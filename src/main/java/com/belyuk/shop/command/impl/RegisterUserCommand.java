package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.AttributeParameterName;
import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.PagePath;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserStatus;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterUserCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
HttpSession session = request.getSession();
//    String status = request.getParameter(AttributeParameterName.STATUS_ATTRIBUTE);
    String lastName = request.getParameter(AttributeParameterName.LAST_NAME_ATTRIBUTE);
    if (lastName == null){
      session.setAttribute("empty_last_name_field", "Enter last name."); //todo
    }
    String name = request.getParameter(AttributeParameterName.NAME_ATTRIBUTE);

    String password = request.getParameter(AttributeParameterName.PASSWORD_ATTRIBUTE);
    String eMail = request.getParameter(AttributeParameterName.EMAIL_ATTRIBUTE);
    String phoneNumber = request.getParameter(AttributeParameterName.PHONE_NUMBER_ATTRIBUTE);
    User user = new User();
    user.setLastName(lastName);
    user.setName(name);
    user.setPassword(password);
    user.seteMail(eMail);
    user.setPhoneNumber(phoneNumber);
    user.setUserStatus(UserStatus.CLIENT);

    try {
      if(userService.registerUser(user)){
        logger.log(Level.INFO, "User register successful");
      }

      } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to register new user.", e);
      throw new CommandException(e);
    }
    return new Router(PagePath.INDEX_PAGE_PATH, Router.RouterType.REDIRECT);
  }
}
