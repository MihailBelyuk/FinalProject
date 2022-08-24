package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE_ATTR;

public class LogoutCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) {
    HttpSession session = request.getSession();
    String page = (String) session.getAttribute(CURRENT_PAGE_ATTR);
    session.invalidate();
    return new Router(page, REDIRECT);
  }
}
