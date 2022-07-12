package com.belyuk.shop.service.impl;

import com.belyuk.shop.entity.BrandName;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.ItemCategory;
import com.belyuk.shop.entity.User;
import com.belyuk.shop.exception.ServiceException;
import com.belyuk.shop.service.ItemService;

import java.math.BigDecimal;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public boolean addItem(String name, BrandName brandName, ItemCategory itemCategory, BigDecimal price, boolean inStock) throws ServiceException {
        return false;
    }

    @Override
    public List<Item> findAllItems() throws ServiceException {
        return null;
    }

    @Override
    public boolean deleteItem(Item item) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateItem(int id, String name, BrandName brandName, ItemCategory itemCategory, BigDecimal price, boolean inStock) throws ServiceException {
        return false;
    }

    @Override
    public User findItemById(int id) throws ServiceException {
        return null;
    }
}
