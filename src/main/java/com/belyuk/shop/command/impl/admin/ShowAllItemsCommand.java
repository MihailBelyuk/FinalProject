package com.belyuk.shop.command.impl.admin;

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

import java.util.List;

import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.ALL_ITEMS_ATTR;
import static com.belyuk.shop.command.constant.PagePath.ITEMS_PAGE;

public class ShowAllItemsCommand implements Command {

  public static final Logger logger = LogManager.getLogger();
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    List<Item> items;
    try {
      items = itemService.findAllItems();
      session.setAttribute(ALL_ITEMS_ATTR, items);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Failed to fulfil 'Show all items command.'", e);
      throw new CommandException("Failed to fulfil 'Show all items command.'", e);
    }
    return new Router(ITEMS_PAGE, REDIRECT);
  }
}
