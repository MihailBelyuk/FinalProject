package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.PagePath.INDEX_PAGE_PATH;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;

public class DefaultCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) {
    return new Router(INDEX_PAGE_PATH, FORWARD);
  }
}
