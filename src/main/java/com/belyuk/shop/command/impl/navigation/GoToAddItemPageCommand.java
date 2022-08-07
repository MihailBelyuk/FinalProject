package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

<<<<<<< HEAD
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.PagePath.ADD_ITEM_PAGE;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;

public class GoToAddItemPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    request.getSession().setAttribute(CURRENT_PAGE_ATTR,ADD_ITEM_PAGE);
    return new Router(ADD_ITEM_PAGE, FORWARD);
=======
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.PagePath.ADD_ITEM_PAGE;

public class GoToAddItemPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    return new Router(ADD_ITEM_PAGE, REDIRECT);
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  }
}
