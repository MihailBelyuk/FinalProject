package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.PagePath;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE_ATTR;
import static com.belyuk.shop.command.constant.PagePath.ADMIN_PAGE;

public class GoToAdminPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
        return new Router(ADMIN_PAGE,FORWARD);
  }
}
