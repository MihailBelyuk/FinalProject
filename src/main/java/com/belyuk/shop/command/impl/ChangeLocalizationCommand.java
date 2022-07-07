package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ChangeLocalizationCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    String locale = request.getParameter("locale");
    String currentPage = String.valueOf(session.getAttribute("current_page"));
    switch (locale) {
      case "ru":
        session.setAttribute("locale", "ru_RU");
        break;
      case "en":
        session.setAttribute("locale", "en_US");
        break;
    }
    return new Router(currentPage, Router.RouterType.FORWARD);
  }
}
