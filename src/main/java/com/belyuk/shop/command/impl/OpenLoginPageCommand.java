package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.PagePath;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class OpenLoginPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    return new Router(PagePath.LOGIN_PAGE_PATH, Router.RouterType.REDIRECT);
  }
}
