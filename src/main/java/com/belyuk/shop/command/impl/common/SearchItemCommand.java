package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.command.constant.PagePath;
import com.belyuk.shop.entity.Cart;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.NO_MATCHING_ITEMS_MSG;

public class SearchItemCommand implements Command {

  private static final Logger logger = LogManager.getLogger();

  private ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
//   Cart cart = (Cart) request.getSession().getAttribute(CART_ATTR);
//
//
//    cart.setItems(itemsInCart);

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
    return new Router(PagePath.MAIN_PAGE, Router.RouterType.FORWARD);
  }
}
