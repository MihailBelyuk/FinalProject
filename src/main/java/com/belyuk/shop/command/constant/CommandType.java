package com.belyuk.shop.command.constant;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.impl.admin.*;
import com.belyuk.shop.command.impl.common.*;
import com.belyuk.shop.command.impl.navigation.*;

public enum CommandType {
  REGISTER(new RegisterUserCommand()),
  LOGIN(new LoginCommand()),
  LOGOUT(new LogoutCommand()),
  DEFAULT(new DefaultCommand()),
  OPEN_REGISTRY_PAGE(new GoToRegistryPageCommand()),
  OPEN_LOGIN_PAGE(new GoToLoginPageCommand()),
  GO_TO_MAIN_PAGE(new GoToMainPageCommand()),
  SHOW_ALL_USERS(new ShowAllUsersCommand()),
  DELETE_USER(new DeleteUserCommand()),
  UPDATE_USER(new UpdateUserCommand()),
  GO_TO_USER_UPDATE_PAGE(new GoToUserUpdatePageCommand()),
  CHANGE_LOCALE(new ChangeLocalizationCommand()),
  SHOW_ALL_ITEMS(new ShowAllItemsCommand()),
  ADD_NEW_ITEM(new AddNewItemCommand()),
  GO_TO_ADD_ITEM_PAGE(new GoToAddItemPageCommand()),
  GO_TO_LOGGED_USER_PAGE(new GoToLoggedUserPageCommand()),
  GO_TO_ADMIN_PAGE(new GoToAdminPageCommand()),
  SEARCH_ITEM(new SearchItemCommand()),
  ADD_TO_CART(new AddToCartCommand()),
  GO_TO_CART(new GoToCartCommand());
  Command command;

  CommandType(Command command) {
    this.command = command;
  }

  public static Command define(String strCommand) {
    if (strCommand == null) {
      return DEFAULT.command;
    }
    CommandType currentCommand;
    try {
      currentCommand = CommandType.valueOf(strCommand.toUpperCase());
    } catch (IllegalArgumentException e) {
      return DEFAULT.command;
    }
    return currentCommand.command;
  }
}
