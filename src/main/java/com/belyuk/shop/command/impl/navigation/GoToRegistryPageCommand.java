package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE_ATTR;
import static com.belyuk.shop.command.constant.PagePath.REGISTER_PAGE;

public class GoToRegistryPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    request.getSession().setAttribute(CURRENT_PAGE_ATTR, REGISTER_PAGE);
    return new Router(REGISTER_PAGE, FORWARD);
  }
}
