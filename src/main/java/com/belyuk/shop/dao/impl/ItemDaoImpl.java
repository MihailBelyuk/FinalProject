package com.belyuk.shop.dao.impl;



import com.belyuk.shop.dao.ItemDao;
import com.belyuk.shop.entity.Item;
import com.belyuk.shop.entity.User;

import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean add(Item item) {
        return false;
    }

    @Override
    public boolean delete(Item item) {
        return false;
    }

    @Override
    public List<Item> selectAll() {
        return null;
    }

    @Override
    public int update(Item item) {
        return 0;
    }

    @Override
    public Item find(long id) {
        return null;
    }
}
