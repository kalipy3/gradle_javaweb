package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.bean.Cart;
import com.servlet.BaseServlet;
import com.utils.WebUtils;

/*
 * CartServlet.java
 * Copyright (C) 2020 2020-12-02 18:44 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class CartServlet extends BaseServlet
{
    //将图书添加到购物车
    protected void add(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        Book book = WebUtils.param2bean2(req, new Book());
        //购物车的整个内容Cart在session中保存
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            //给session中放入购物车
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        cart.addBook2Cart(book);
        String refer = req.getHeader("referer");
        resp.sendRedirect(refer);
    }
}

