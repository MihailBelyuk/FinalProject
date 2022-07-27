package com.belyuk.shop.command;

import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/** The interface Command. */
@FunctionalInterface
public interface Command {

  /**
   * Execute command.
   *
   * @param request the request of HttpServlet
   * @return the router and page path
   * @throws CommandException the command exception
   */
  Router execute(HttpServletRequest request) throws CommandException;
}
