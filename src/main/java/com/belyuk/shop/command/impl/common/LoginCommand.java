package com.belyuk.shop.command.impl.common;

<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LoginCommand.java
=======
import com.belyuk.shop.command.constant.AttributeParameterName;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LoginCommand.java
import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.AttributeParameterName;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.entity.UserRole;
import com.belyuk.shop.entity.service.impl.UserServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LoginCommand.java
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.INCORRECT_LOGIN_OR_PASSWORD_MSG;
import static com.belyuk.shop.command.constant.PagePath.*;
=======
import static com.belyuk.shop.command.constant.PagePath.*;
import static com.belyuk.shop.command.Router.RouterType.*;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LoginCommand.java

public class LoginCommand implements Command {

  public static final Logger logger = LogManager.getLogger();
<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LoginCommand.java
  private static final String LOGOUT = "Logout";
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
=======
  private UserServiceImpl userService = UserServiceImpl.getUserService();
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LoginCommand.java

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String eMail = request.getParameter(AttributeParameterName.EMAIL_ATTR);
    String password = request.getParameter(AttributeParameterName.PASSWORD_ATTR);
    String page = null;
    HttpSession session = request.getSession();
    try {
      if (userService.login(eMail, password)) {
        List<User> users = UserServiceImpl.getUserService().findAllUsers();
        for (User user : users) {
          if (user.geteMail().equals(eMail)) {
            UserRole status = user.getUserRole();
<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LoginCommand.java
            page = switch (status) {
              case ADMIN -> ADMIN_PAGE;
              case CLIENT -> CLIENT_PAGE;
            };
            session.setAttribute(LOGGED_USER_PAGE_ATTR, page);
=======
            switch (status) {
              case ADMIN:
                page = ADMIN_PAGE;
                break;
              case CLIENT:
                page = MAIN_PAGE;
                break;
            }
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LoginCommand.java
          }
        }
        session.setAttribute(LOGGED_USER_ATTR, eMail);
        session.setAttribute(LOGOUT_ATTR, LOGOUT);
      } else {
        page = LOGIN_PAGE;
<<<<<<< HEAD:src/main/java/com/belyuk/shop/command/impl/common/LoginCommand.java
        session.setAttribute(LOGIN_MSG_ATTR, INCORRECT_LOGIN_OR_PASSWORD_MSG);
=======
        session.setAttribute("login_msg", "Incorrect login or password");
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2:src/main/java/com/belyuk/shop/command/impl/LoginCommand.java
      }
    } catch (ServiceException e) {
      logger.log(Level.WARN, "Authentication failed.", e);
      throw new CommandException("Authentication failed.", e);
    }
    return new Router(page, REDIRECT);
  }
}
