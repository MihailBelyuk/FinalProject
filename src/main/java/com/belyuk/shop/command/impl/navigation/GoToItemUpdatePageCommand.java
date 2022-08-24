package com.belyuk.shop.command.impl.navigation;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.PagePath.ITEM_UPDATE_PAGE;

public class GoToItemUpdatePageCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    session.setAttribute(CURRENT_PAGE_ATTR, ITEM_UPDATE_PAGE);
    Item item;
    try {
      item = itemService.findItemById(Integer.parseInt(request.getParameter(ITEM_ID)))
              .orElseThrow(()->new CommandException("Item is null."));
      session.setAttribute(ITEM_CATEGORY_ATTR, item.getItemCategory().toString());
      session.setAttribute(BRAND_ATTR, item.getBrandName());
      session.setAttribute(PICTURE_ATTR, item.getEncodedImage());
      session.setAttribute(ITEM_NAME_ATTR, item.getName());
      session.setAttribute(DESCRIPTION_ATTR, item.getDescription());
      session.setAttribute(PRICE_ATTR, item.getPrice().toString());
      session.setAttribute(IN_STOCK_ATTR, item.isInStock());
      session.setAttribute(ITEM_ID_ATTR, item.getId());
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to find user by ID.", e);
      throw new CommandException("Failed to find user by ID.", e);
    }
    return new Router(ITEM_UPDATE_PAGE, FORWARD);
  }
}
