package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.PagePath;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.PagePath.MAIN_PAGE_PATH;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static  com.belyuk.shop.command.AttributeParameterName.*;
public class GoToMainPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    request.getSession().setAttribute(CURRENT_PAGE, MAIN_PAGE_PATH);
    return new Router(MAIN_PAGE_PATH, FORWARD);
  }
}
