package com.sheliming.bookstore.model.entity;

public class CartItem {
    private Book book;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return book.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
