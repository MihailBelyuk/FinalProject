package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import static com.belyuk.shop.command.PagePath.*;
import static com.belyuk.shop.command.Router.RouterType.*;

public class ShowAllItemsCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        return new Router(ITEMS_PAGE,REDIRECT);
    }
}
