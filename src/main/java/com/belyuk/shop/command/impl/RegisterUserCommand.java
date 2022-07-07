package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.AttributeParameterName;
import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;

public class RegisterUserCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String currentPage = String.valueOf(request.getSession().getAttribute("current_page"));
    String lastName = request.getParameter(AttributeParameterName.LAST_NAME_ATTRIBUTE);
    request.setAttribute("last_name", lastName);
    if (lastName == "") {
      request.setAttribute("empty_last_name_field", "Last name field must not be empty.");
    }
    String name = request.getParameter(AttributeParameterName.NAME_ATTRIBUTE);
    request.setAttribute("name", name);
    if (name == "") {
      request.setAttribute("empty_name_field", "Name field must not be empty.");
    }
    String password = request.getParameter(AttributeParameterName.PASSWORD_ATTRIBUTE);
    request.setAttribute("password", password);
    if (password == "") {
      request.setAttribute("empty_password_field", "Password field must not be empty.");
    }
    String eMail = request.getParameter(AttributeParameterName.EMAIL_ATTRIBUTE);
    request.setAttribute("e_mail", eMail);
    if (eMail == "") {
      request.setAttribute("empty_email_field", "E-mail field must not be empty.");
    }
    String phoneNumber = request.getParameter(AttributeParameterName.PHONE_NUMBER_ATTRIBUTE);
    request.setAttribute("phone_number", phoneNumber);
    if (phoneNumber == "") {
      request.setAttribute("empty_phone_number_field", "Phone number field must not be empty.");
    }
    try {
      if (userService.registerUser(lastName, name, password, eMail, phoneNumber)) {
        logger.log(Level.INFO, "User register successful");
      }

    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to register new user.", e);
      throw new CommandException(e);
    }
    return new Router(currentPage, FORWARD);
  }
}
