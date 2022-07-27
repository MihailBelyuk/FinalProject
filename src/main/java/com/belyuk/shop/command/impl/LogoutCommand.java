package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.constant.PagePath.INDEX_PAGE;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;

public class LogoutCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) {
    request.getSession().invalidate();
    return new Router(INDEX_PAGE, FORWARD);
  }
}
