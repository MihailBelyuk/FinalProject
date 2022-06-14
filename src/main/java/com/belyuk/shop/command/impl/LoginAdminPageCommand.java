package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginAdminPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        
        return null;
    }
}
