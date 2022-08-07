package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

<<<<<<< HEAD
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE_ATTR;
import static com.belyuk.shop.command.constant.PagePath.REGISTER_PAGE;
=======
import static com.belyuk.shop.command.constant.PagePath.REGISTER_PAGE;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2

public class GoToRegistryPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
<<<<<<< HEAD
    request.getSession().setAttribute(CURRENT_PAGE_ATTR, REGISTER_PAGE);
=======
    request.getSession().setAttribute(CURRENT_PAGE, REGISTER_PAGE);
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
    return new Router(REGISTER_PAGE, FORWARD);
  }
}
