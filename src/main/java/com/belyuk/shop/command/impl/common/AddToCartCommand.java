package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.Cart;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.OUT_OF_STOCK_MSG;
import static com.belyuk.shop.command.constant.PagePath.MAIN_PAGE;

public class AddToCartCommand implements Command {

  private ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    Cart cart = (Cart) request.getSession().getAttribute(CART_ATTR);
    List<Item> items = cart.getItems();
    List<Item> itemList = (List<Item>) request.getSession().getAttribute(SEARCH_ITEMS_ATTR);
    String itemName = request.getParameter(ITEM_NAME);
    for (Item item : itemList) {
      if (item.getName().equals(itemName)) {
        if (item.isInStock()) {
          items.add(item);
        } else {
          request.setAttribute(OUT_OF_STOCK_ATTR, OUT_OF_STOCK_MSG);
          return new Router(MAIN_PAGE, FORWARD);
        }
      }
    }
    cart.setItems(items);
    return new Router(MAIN_PAGE, REDIRECT);
  }
}
