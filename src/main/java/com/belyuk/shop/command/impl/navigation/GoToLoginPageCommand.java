package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE;
import static com.belyuk.shop.command.constant.PagePath.LOGIN_PAGE;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;

public class GoToLoginPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    session.setAttribute(CURRENT_PAGE, LOGIN_PAGE);
    return new Router(LOGIN_PAGE, REDIRECT);
  }
}
