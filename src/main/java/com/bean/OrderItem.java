package com.bean;
/*
 * OrderItem.java
 * Copyright (C) 2020 2020-12-03 15:22 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderItem
{
    private String title;//购买的书名
    private int count;//购买的数量
    private double price;//图书的价格
    private double totalPrice;//图书的总价
    private String orderId;//属于哪个订单

    public OrderItem() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderItem(String title, int count, double price, double totalPrice, String orderId) {
        this.title = title;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
            "title = " + getTitle() +
            ", count = " + getCount() +
            ", price = " + getPrice() +
            ", totalPrice = " + getTotalPrice() +
            ", orderId = " + getOrderId() +
            "}";
    }

}

