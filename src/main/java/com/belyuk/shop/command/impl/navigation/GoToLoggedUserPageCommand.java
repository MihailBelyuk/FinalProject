package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class GoToLoggedUserPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String page = (String) request.getSession().getAttribute("logged_user_page");
    return new Router(page, Router.RouterType.FORWARD);
  }
}
