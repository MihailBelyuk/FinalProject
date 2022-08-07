package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.AttributeParameterName;
import com.belyuk.shop.command.constant.PagePath;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.entity.service.validator.impl.UserValidatorImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.*;

public class RegisterUserCommand implements Command {

  private static final Logger logger = LogManager.getLogger();

  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private final UserValidatorImpl userValidator = UserValidatorImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String currentPage = String.valueOf(request.getSession().getAttribute(CURRENT_PAGE_ATTR));

    String lastName = request.getParameter(AttributeParameterName.LAST_NAME_ATTR).strip();
    if (lastName.isBlank()) {
      request.setAttribute(EMPTY_LAST_NAME_ATTR, FILL_LAST_NAME_MSG);
    } else if (!userValidator.validateLastName(lastName)) {
      request.setAttribute(WRONG_INPUT_LAST_NAME_ATTR, WRONG_LAST_NAME_FORMAT_MSG);
    } else {
      request.setAttribute(LAST_NAME_ATTR, lastName);
    }

    String name = request.getParameter(AttributeParameterName.NAME_ATTR).strip();
    if (name.isBlank()) {
      request.setAttribute(EMPTY_NAME_ATTR, FILL_NAME_MSG);
    } else if (!userValidator.validateUserName(name)) {
      request.setAttribute(WRONG_INPUT_NAME_ATTR, WRONG_NAME_FORMAT_MSG);
    } else {
      request.setAttribute(NAME_ATTR, name);
    }

    String password = request.getParameter(AttributeParameterName.PASSWORD_ATTR).strip();
    if (password.isBlank()) {
      request.setAttribute(EMPTY_PASSWORD_ATTR, FILL_PASSWORD_MSG);
    } else if (!userValidator.validatePassword(password)) {
      request.setAttribute(WRONG_INPUT_PASSWORD_ATTR, WRONG_PASSWORD_FORMAT_MSG);
    } else {
      request.setAttribute(PASSWORD_ATTR, password);
    }

    String eMail = request.getParameter(AttributeParameterName.EMAIL_ATTR).strip();
    try {
      if (eMail.isBlank()) {
        request.setAttribute(EMPTY_E_MAIL_ATTR, FILL_E_MAIL_MSG);
      } else if (!userValidator.validateEmail(eMail)) {
        request.setAttribute(WRONG_INPUT_E_MAIL_ATTR, WRONG_E_MAIL_FORMAT_MSG);
      } else if (userService.checkByEmailIfUserExist(eMail)) {
        request.setAttribute(USER_EXISTS_ATTR, USER_EXISTS_MSG);
        return new Router(currentPage, FORWARD);
      } else request.setAttribute(EMAIL_ATTR, eMail);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to register user", e);
      throw new CommandException("Failed to register user", e);
    }

    String phoneNumber = request.getParameter(AttributeParameterName.PHONE_NUMBER_ATTR).strip();
    if (phoneNumber.isBlank()) {
      request.setAttribute(EMPTY_PHONE_NUMBER_ATTR, FILL_PHONE_NUMBER_MSG);
    } else if (userValidator.validatePhoneNumber(phoneNumber)) {
      request.setAttribute(WRONG_INPUT_PHONE_NUMBER_ATTR, WRONG_PHONE_NUMBER_FORMAT_MSG);
    }

    if (!lastName.isBlank()
        && !name.isBlank()
        && !password.isBlank()
        && !eMail.isBlank()
        && !phoneNumber.isBlank()) {
      if (userValidator.validateLastName(lastName)
          && userValidator.validateUserName(name)
          && userValidator.validatePassword(password)
          && userValidator.validateEmail(eMail)
          && userValidator.validatePhoneNumber(phoneNumber)) {

        try {
          if (!userService.registerUser(lastName, name, password, eMail, phoneNumber)) {
            request
                .getSession()
                .setAttribute(REGISTRATION_SUCCESSFUL_ATTR, REGISTRATION_SUCCESS_MSG);
            logger.log(Level.INFO, "User register successful");
            return new Router(PagePath.MAIN_PAGE, REDIRECT);
          }
        } catch (ServiceException e) {
          logger.log(Level.ERROR, "Failed to register new user.", e);
          throw new CommandException(e);
        }
      }
    }
    return new Router(currentPage, FORWARD);
  }
}
