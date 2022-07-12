package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.AttributeParameterName.*;

public class ChangeLocalizationCommand implements Command {

  enum  Localization{
    ;
    public static final String RU = "ru_RU";
    public static final String EN = "en_US";
  }

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    String locale = request.getParameter(LOCALE_PARAM);
    String currentPage = String.valueOf(session.getAttribute(CURRENT_PAGE));
    switch (locale) {
      case RU_PARAMETER:
        session.setAttribute(LOCALIZATION, Localization.RU);
        break;
      case EN_PARAMETER:
        session.setAttribute(LOCALIZATION, Localization.EN);
        break;
    }
    return new Router(currentPage, Router.RouterType.FORWARD);
  }
}
