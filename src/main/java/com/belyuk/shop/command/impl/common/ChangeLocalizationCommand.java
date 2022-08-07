package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.constant.AttributeParameterName.*;

public class ChangeLocalizationCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    String locale = request.getParameter(LOCALE_PARAM);
    String currentPage = String.valueOf(session.getAttribute(CURRENT_PAGE_ATTR));
    switch (locale) {
      case RU_PARAMETER -> session.setAttribute(LOCALIZATION_ATTR, Localization.RU);
      case EN_PARAMETER -> session.setAttribute(LOCALIZATION_ATTR, Localization.EN);
    }
    return new Router(currentPage, Router.RouterType.FORWARD);
  }

  enum Localization {
    ;
    public static final String RU = "ru_RU";
    public static final String EN = "en_US";
  }
}
