package com.belyuk.shop.command;

import com.belyuk.shop.command.impl.*;

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
  CHANGE_LOCALE(new ChangeLocalizationCommand());
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
