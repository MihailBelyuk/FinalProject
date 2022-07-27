package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.Cart;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.CART_ATTR;
import static com.belyuk.shop.command.constant.AttributeParameterName.CURRENT_PAGE_ATTR;
import static com.belyuk.shop.command.constant.PagePath.MAIN_PAGE;

public class GoToMainPageCommand implements Command {

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    request.getSession().setAttribute(CURRENT_PAGE_ATTR, MAIN_PAGE);
    Cart cart = new Cart();
    List<Item> itemsInCart = new ArrayList<>();
    cart.setItems(itemsInCart);
    request.getSession().setAttribute(CART_ATTR, cart);
    return new Router(MAIN_PAGE, FORWARD);
  }
}
