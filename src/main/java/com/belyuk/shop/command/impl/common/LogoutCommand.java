package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LogoutCommand.java
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.PagePath.LOGIN_PAGE;
=======
import static com.belyuk.shop.command.constant.PagePath.INDEX_PAGE;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LogoutCommand.java

public class LogoutCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) {
<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LogoutCommand.java
    HttpSession session = request.getSession();
    session.invalidate();
    return new Router(LOGIN_PAGE, FORWARD);
=======
    request.getSession().invalidate();
    return new Router(INDEX_PAGE, FORWARD);
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LogoutCommand.java
  }
}
