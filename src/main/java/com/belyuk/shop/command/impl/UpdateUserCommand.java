package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.PagePath.USERS_PAGE;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;

public class UpdateUserCommand implements Command {
  private UserServiceImpl userService = UserServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    int id = Integer.valueOf((String) session.getAttribute("id")) ;
    UserRole userRole = UserRole.valueOf(request.getParameter("role").toUpperCase());
    String lastName = request.getParameter("last_name");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String eMail = request.getParameter("e_mail");
    String phoneNumber = request.getParameter("phone_number");
    try {
      userService.updateUser(id,userRole, lastName, name, password, eMail, phoneNumber);
    } catch (ServiceException e) {
      throw new CommandException(e); // TODO: log and exception
    }
    return new Router(USERS_PAGE, REDIRECT);
  }
}
