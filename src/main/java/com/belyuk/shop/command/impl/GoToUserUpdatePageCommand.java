package com.belyuk.shop.command.impl;

import com.belyuk.shop.command.Command;
import com.belyuk.shop.command.Router;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.CommandException;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static com.belyuk.shop.command.PagePath.*;
import static com.belyuk.shop.command.Router.RouterType.*;

public class GoToUserUpdatePageCommand implements Command {
    private UserServiceImpl userService = UserServiceImpl.getInstance();
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        HttpSession session =request.getSession();
        User user;
        try {
            user = userService.findUserById(Integer.parseInt(request.getParameter("userId")));
            session.setAttribute( "user_role",user.getUserRole().toString());
            session.setAttribute("last_name", user.getLastName());
            session.setAttribute("name",user.getName());
            session.setAttribute("password","Password");
            session.setAttribute("e_mail", user.geteMail());
            session.setAttribute("phone_number", user.getPhoneNumber());
            session.setAttribute("id", request.getParameter("userId"));
        } catch (ServiceException e) {
            throw new CommandException(e); // TODO: log and exception
        }
        return new Router(USER_UPDATE_PAGE,FORWARD);
    }
}
