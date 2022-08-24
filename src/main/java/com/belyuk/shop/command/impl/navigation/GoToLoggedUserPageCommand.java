package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.LOGGED_USER_PAGE_ATTR;

public class GoToLoggedUserPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String page = (String) request.getSession().getAttribute(LOGGED_USER_PAGE_ATTR);
    return new Router(page, FORWARD);
  }
}
