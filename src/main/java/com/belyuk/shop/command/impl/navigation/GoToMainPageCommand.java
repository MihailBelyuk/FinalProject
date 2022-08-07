package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
<<<<<<< HEAD
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
=======
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.constant.PagePath.MAIN_PAGE;
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
public class GoToMainPageCommand implements Command {
  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    request.getSession().setAttribute(CURRENT_PAGE, MAIN_PAGE);
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
    return new Router(MAIN_PAGE, FORWARD);
  }
}
