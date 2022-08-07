package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

<<<<<<< HEAD
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
=======
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE;
import static com.belyuk.shop.command.constant.PagePath.LOGIN_PAGE;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE_ATTR;
import static com.belyuk.shop.command.constant.PagePath.LOGIN_PAGE;

public class GoToLoginPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
<<<<<<< HEAD
    session.setAttribute(CURRENT_PAGE_ATTR, LOGIN_PAGE);
    return new Router(LOGIN_PAGE, FORWARD);
=======
    session.setAttribute(CURRENT_PAGE, LOGIN_PAGE);
    return new Router(LOGIN_PAGE, REDIRECT);
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  }
}
