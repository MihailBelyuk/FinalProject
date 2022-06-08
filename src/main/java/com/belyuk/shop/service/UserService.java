package com.belyuk.shop.service;


import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean login(String login, String password) throws ServiceException;
    boolean registerUser(User user) throws ServiceException;
    List<User> findAllUsers() throws ServiceException;
}
