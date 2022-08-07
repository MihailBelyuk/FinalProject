package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.PagePath;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class GoToAdminPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    return new Router(PagePath.ADMIN_PAGE, Router.RouterType.REDIRECT);
  }
}
