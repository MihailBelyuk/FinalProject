package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.ItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.PagePath.MAIN_PAGE;

public class AddNewItemCommand implements Command {
  public static final Logger logger = LogManager.getLogger();
  private static final String IN_STOCK = "in_stock";
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    ItemCategory category = ItemCategory.valueOf(request.getParameter(ITEM_CATEGORY).toUpperCase());
    String brand = request.getParameter(BRAND);

    String name = request.getParameter(ITEM_NAME);
    String description = request.getParameter(DESCRIPTION);
    BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
    String stockCheck = String.valueOf(request.getParameter(STOCK));
    boolean stock;
    stock = stockCheck.equals(IN_STOCK);
    try {
      InputStream picture = request.getPart(PICTURE).getInputStream();
      itemService.addItem(category, brand, picture, name, description, price, stock);
    } catch (ServiceException | IOException | ServletException e) {
      logger.log(Level.ERROR, "Failed to fulfil 'AddNewItemCommand'.", e);
      throw new CommandException(
          "Failed to fulfil 'AddNewItemCommand'.", e);
    }
    return new Router(MAIN_PAGE, REDIRECT);
  }
}
