package com.bean;
/*
 * Book.java
 * Copyright (C) 2020 2020-11-29 00:49 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Book
{
    //图书馆的主键
    private Integer id;

    //图书的书名
    private String title;

    private String author;

    private double price;

    //图书的销量
    private int sales;

    private int stock;

    //图片的封面路径，写相对于项目的相对路径
    private String imgPath = "static/img/default.png";

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id = " + getId() +
            ", title = " + getTitle() +
            ", author = " + getAuthor() +
            ", price = " + getPrice() +
            ", sales = " + getSales() +
            ", stock = " + getStock() +
            ", imgPath = " + getImgPath() +
            "}";
    }

    public Book(Integer id, String title, String author, double price, int sales, int stock, String imgPath) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        //this.imgPath = imgPath;
        if (imgPath != null) {
            this.imgPath = imgPath;
        }
    }

}

