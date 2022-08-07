package com.belyuk.shop.command.impl.common;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.Cart;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.EMPTY_CART_MSG;
import static com.belyuk.shop.command.constant.PagePath.CART_PAGE;

public class GoToCartCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    Optional<Cart> cart = Optional.ofNullable((Cart) request.getSession().getAttribute(CART_ATTR));
    if (cart.isPresent()) {
      List<Item> itemsInCart = cart.get().getItems();
      request.setAttribute(ITEMS_IN_CART, itemsInCart);
    } else {
      request.setAttribute(EMPTY_CART, EMPTY_CART_MSG);
    }
    return new Router(CART_PAGE, FORWARD);
  }
}
