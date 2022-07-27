package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.PagePath.LOGIN_PAGE;

public class LogoutCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return new Router(LOGIN_PAGE, FORWARD);
  }
}
