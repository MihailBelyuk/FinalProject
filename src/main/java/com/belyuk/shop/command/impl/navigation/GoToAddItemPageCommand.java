package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.PagePath.ADD_ITEM_PAGE;

public class GoToAddItemPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    return new Router(ADD_ITEM_PAGE, REDIRECT);
  }
}
