package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.PagePath.REGISTER_PAGE_PATH;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;

public class GoToRegistryPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    request.getSession().setAttribute("current_page",REGISTER_PAGE_PATH);
    return new Router(REGISTER_PAGE_PATH, FORWARD);
  }
}
