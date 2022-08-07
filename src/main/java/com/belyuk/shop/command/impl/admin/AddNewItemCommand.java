package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.FIELDS_SHOULD_BE_FILLED_MSG;
import static com.belyuk.shop.command.constant.PagePath.ADMIN_PAGE;

public class AddNewItemCommand implements Command {

  public static final Logger logger = LogManager.getLogger();
  private static final String IN_STOCK = "in_stock";
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {

    String currentPage = String.valueOf(request.getSession().getAttribute(CURRENT_PAGE_ATTR));
    String itemCategory = request.getParameter(ITEM_CATEGORY).toUpperCase();
    ItemCategory category = ItemCategory.valueOf(itemCategory);
    String brand = request.getParameter(BRAND).strip();
    String name = request.getParameter(ITEM_NAME).toUpperCase().strip();
    String description = request.getParameter(DESCRIPTION).strip();
    BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter(PRICE)));
    String stockCheck = String.valueOf(request.getParameter(STOCK));
    boolean stock = stockCheck.equals(IN_STOCK);
    if (itemCategory.isBlank() | brand.isBlank() | name.isBlank() | description.isBlank()) {
      request.setAttribute(FIELDS_MUST_BE_FILLED_ATTR, FIELDS_SHOULD_BE_FILLED_MSG);
      return new Router(currentPage, FORWARD);
    } else {
      try {
        InputStream picture = request.getPart(PICTURE).getInputStream();
        byte[] pictureInBytes = picture.readAllBytes();
        itemService.addItem(category, brand, pictureInBytes, name, description, price, stock);
      } catch (ServiceException | IOException | ServletException e) {
        logger.log(Level.ERROR, "Failed to fulfil 'AddNewItemCommand'.", e);
        throw new CommandException("Failed to fulfil 'AddNewItemCommand'.", e);
      }
      return new Router(ADMIN_PAGE, REDIRECT);
    }
  }
}
