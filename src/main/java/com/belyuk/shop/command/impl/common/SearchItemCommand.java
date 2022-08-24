package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.NO_MATCHING_ITEMS_MSG;
import static com.belyuk.shop.command.constant.PagePath.MAIN_PAGE;

public class SearchItemCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    String nameQuery = request.getParameter(SEARCH).toUpperCase();
    try {
      List<Item> items = itemService.findItemByName(nameQuery);
      if (!nameQuery.isEmpty()) {
        if (items.isEmpty()) {
          request.setAttribute(NO_MATCHING_ITEMS_ATTR, NO_MATCHING_ITEMS_MSG);
        } else {
          request.getSession().setAttribute(SEARCH_ITEMS_ATTR, items);
        }
      }
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Search item command failed", e);
      throw new CommandException("Search item command failed", e);
    }
    return new Router(MAIN_PAGE, REDIRECT);
  }
}
