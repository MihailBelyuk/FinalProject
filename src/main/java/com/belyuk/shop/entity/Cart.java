package com.belyuk.shop.entity;

import java.util.List;

public class Cart {
    private User user;
    private List<Item> items;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (user != null ? !user.equals(cart.user) : cart.user != null) return false;
        return items != null ? items.equals(cart.items) : cart.items == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("user=").append(user);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
