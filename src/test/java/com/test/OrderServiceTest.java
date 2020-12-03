package com.test;

import org.junit.Test;

import com.bean.Book;
import com.bean.Cart;
import com.bean.User;
import com.service.BookService;
import com.service.BookServiceImpl;
import com.service.OrderService;
import com.service.OrderServiceImpl;

/*
 * OrderServiceTest.java
 * Copyright (C) 2020 2020-12-03 20:16 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderServiceTest
{
    BookService bookService = new BookServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test 
    public void test() {
        Book book = new Book();
        book.setId(7);
        Book one = bookService.getOne(book);
        Cart cart = new Cart();
        cart.addBook2Cart(one);
        cart.addBook2Cart(one);

        String orderid = orderService.checkout(cart, new User(1, "", "", ""));
        System.out.println(orderid);
    
    }
}

