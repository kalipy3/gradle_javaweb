package com.bean;

import com.bean.Book;

/*
 * CartItem.java
 * Copyright (C) 2020 2020-12-02 15:37 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class CartItem
{
    //代表当前买的是哪本书
    private Book book;
    //代表购买的数量
    private int count;
    //代表总金额
    private double totalPrice;

    public CartItem() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //计算总金额
    public double getTotalPrice() {
        return getBook().getPrice()*getCount();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartItem(Book book, int count, double totalPrice) {
        this.book = book;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
            "book = " + getBook() +
            ", count = " + getCount() +
            ", totalPrice = " + getTotalPrice() +
            "}";
    }

}

