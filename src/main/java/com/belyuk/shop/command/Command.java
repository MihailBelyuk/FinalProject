package com.belyuk.shop.command;


import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface Command {
  Router execute(HttpServletRequest request) throws CommandException;
}
