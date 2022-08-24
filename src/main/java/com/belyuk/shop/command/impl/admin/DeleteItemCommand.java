package com.belyuk.shop.command.impl.admin;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.service.impl.ItemServiceImpl;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.belyuk.shop.command.constant.AttributeParameterName.ITEM_ID;

public class DeleteItemCommand implements Command {
  private static final Logger logger = LogManager.getLogger();
  private final ItemServiceImpl itemService = ItemServiceImpl.getInstance();

  @Override
  public Router execute(HttpServletRequest request) throws CommandException {
    int id = Integer.parseInt(request.getParameter(ITEM_ID));
    try {
      itemService.deleteItem(id);
      return new ShowAllItemsCommand().execute(request);
    } catch (ServiceException e) {
      logger.log(Level.ERROR, "Delete item command failed.", e);
      throw new CommandException("Delete item command failed.", e);
    }
  }
}
