package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import jakarta.servlet.http.HttpServletRequest;

<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/DefaultCommand.java
=======
import static com.belyuk.shop.command.constant.PagePath.INDEX_PAGE;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/DefaultCommand.java
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.PagePath.INDEX_PAGE;

public class DefaultCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) {
    return new Router(INDEX_PAGE, FORWARD);
  }
}
