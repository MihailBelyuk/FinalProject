package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.PagePath.*;
import static com.belyuk.shop.command.Router.RouterType.*;

public class GoToLoginPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    session.setAttribute("current_page", LOGIN_PAGE_PATH);
    return new Router(LOGIN_PAGE_PATH,REDIRECT);
  }
}
