package com.belyuk.shop.command;

import com.belyuk.shop.command.impl.*;

public enum CommandType {
  REGISTER(new RegisterUserCommand()),
  LOGIN(new LoginCommand()),
  LOGOUT(new LogoutCommand()),
  DEFAULT(new DefaultCommand()),
  OPEN_REGISTRY_PAGE(new OpenRegistryPageCommand()),
  OPEN_LOGIN_PAGE(new OpenLoginPageCommand()),
  GO_TO_MAIN_PAGE(new GoToMainPageCommand()),
  GO_TO_ADMIN_PAGE(new GoToAdminPageCommand()),
  SHOW_ALL_USERS(new ShowAllUsersCommand());
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
