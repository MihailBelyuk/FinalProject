package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.AttributeParameterName;
import com.belyuk.shop.command.constant.PagePath;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;

public class RegisterUserCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private static final String EMPTY_INPUT = "";
  private UserServiceImpl userService = UserServiceImpl.getUserService();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String currentPage = String.valueOf(request.getSession().getAttribute(CURRENT_PAGE));
    String lastName = request.getParameter(AttributeParameterName.LAST_NAME_ATTRIBUTE);
    String name = request.getParameter(AttributeParameterName.NAME_ATTRIBUTE);
    String password = request.getParameter(AttributeParameterName.PASSWORD_ATTRIBUTE);
    String eMail = request.getParameter(AttributeParameterName.EMAIL_ATTRIBUTE);
    String phoneNumber = request.getParameter(AttributeParameterName.PHONE_NUMBER_ATTRIBUTE);
    request.setAttribute(LAST_NAME_ATTRIBUTE, lastName);
    request.setAttribute(NAME_ATTRIBUTE, name);
    request.setAttribute(PASSWORD_ATTRIBUTE, password);
    request.setAttribute(EMAIL_ATTRIBUTE, eMail);
    request.setAttribute(PHONE_NUMBER_ATTRIBUTE, phoneNumber);
    if (!lastName.equals(EMPTY_INPUT)
        & !name.equals(EMPTY_INPUT)
        & !password.equals(EMPTY_INPUT)
        & !eMail.equals(EMPTY_INPUT)
        & !phoneNumber.equals(EMPTY_INPUT)) {
      try {
        if (!userService.registerUser(lastName, name, password, eMail, phoneNumber)) {
          request.getSession().setAttribute("registration_successful", "Registration successful!!");
          logger.log(Level.INFO, "User register successful");
          return new Router(PagePath.MAIN_PAGE, REDIRECT);
        }
      } catch (ServiceException e) {
        logger.log(Level.ERROR, "Failed to register new user.", e);
        throw new CommandException(e);
      }
    }
    return new Router(currentPage, FORWARD);
  }
}
