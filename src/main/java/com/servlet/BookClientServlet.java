package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.bean.Page;
import com.service.BookService;
import com.service.BookServiceImpl;
import com.servlet.BaseServlet;

/*
 * BookClientServlet.java
 * Copyright (C) 2020 2020-11-30 15:10 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class BookClientServlet extends BaseServlet
{
    BookService bookService = new BookServiceImpl();
    
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入分页逻辑");
        //用户点击图书管理显示部分数据,页码应该是用户传进来的
        String pn = req.getParameter("pn");
        Page<Book> page = bookService.getPage(pn, "4");
        page.setUrl("client/BookClientServlet?method=page");
        //将第一页的数据放到页面显示
        req.setAttribute("page", page);
        //交给页面
        req.getRequestDispatcher("/pages/book/booklist.jsp").forward(req, resp);
    }
}

