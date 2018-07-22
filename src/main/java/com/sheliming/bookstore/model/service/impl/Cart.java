package com.sheliming.bookstore.model.service.impl;

import com.sheliming.bookstore.model.entity.Book;
import com.sheliming.bookstore.model.entity.CartItem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public void addBook(Book book) {
        CartItem cartItem = items.get(book.getId());
        if (null == cartItem) {
            cartItem = new CartItem(book);
            cartItem.setQuantity(1);
            items.put(book.getId(), cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (CartItem item : items.values()) {
            total += item.getBook().getPrice() * item.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    public void delete(int id) {
        CartItem item = items.get(id);
        if (null != item) {
            items.remove(id);
        }
    }
}
