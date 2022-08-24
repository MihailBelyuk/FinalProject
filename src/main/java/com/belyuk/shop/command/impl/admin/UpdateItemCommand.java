package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static com.belyuk.shop.command.Router.RouterType.FORWARD;
import static com.belyuk.shop.command.constant.AttributeParameterName.*;
import static com.belyuk.shop.command.constant.Message.FIELDS_SHOULD_BE_FILLED_MSG;

public class UpdateItemCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private static final ItemServiceImpl itemService = ItemServiceImpl.getInstance();
  private static final String IN_STOCK = "in_stock";

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    try (InputStream picture = request.getPart(PICTURE).getInputStream()) {
      byte[] pictureInBytes = picture.readAllBytes();
      String currentPage = (String) session.getAttribute(CURRENT_PAGE_ATTR);
      int id = Integer.parseInt(String.valueOf(session.getAttribute(ITEM_ID_ATTR)));
      ItemCategory itemCategory =
          ItemCategory.valueOf(request.getParameter(ITEM_CATEGORY).toUpperCase());
      String brand = request.getParameter(BRAND);
      String name = request.getParameter(ITEM_NAME);
      String description = request.getParameter(DESCRIPTION);
      BigDecimal price = new BigDecimal(request.getParameter(PRICE));
      String stockCheck = String.valueOf(request.getParameter(STOCK));
      boolean stock = stockCheck.equals(IN_STOCK);
      itemService.updateItem(
          id, itemCategory, brand, pictureInBytes, name, description, price, stock);
      if (brand.isBlank() || name.isBlank() || description.isBlank()) {
        request.setAttribute(FIELDS_MUST_BE_FILLED_ATTR, FIELDS_SHOULD_BE_FILLED_MSG);
        return new Router(currentPage, FORWARD);
      }
    } catch (IOException | ServletException | ServiceException e) {
      logger.log(Level.ERROR, "Item update command failed.", e);
      throw new CommandException("Item update command failed.", e);
    }
    return new ShowAllItemsCommand().execute(request);
  }
}
