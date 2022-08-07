package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.PagePath.INDEX_PAGE;

public class DefaultCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) {
    return new Router(INDEX_PAGE, FORWARD);
  }
}
