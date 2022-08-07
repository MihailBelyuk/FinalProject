package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.ItemCategory;
<<<<<<< HEAD
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
=======
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.ItemServiceImpl;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

<<<<<<< HEAD
import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.FIELDS_SHOULD_BE_FILLED_MSG;
import static com.belyuk.shop.command.constant.PagePath.ADMIN_PAGE;

public class AddNewItemCommand implements Command {

=======
import static com.belyuk.shop.command.Router.RouterType.REDIRECT;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.PagePath.MAIN_PAGE;

public class AddNewItemCommand implements Command {
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  public static final Logger logger = LogManager.getLogger();
  private static final String IN_STOCK = "in_stock";
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
<<<<<<< HEAD
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
=======
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
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  }
}
