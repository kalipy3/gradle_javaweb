package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.service.BookService;
import com.service.BookServiceImpl;
import com.servlet.BaseServlet;
import com.utils.WebUtils;

/*
 * BookManagerServlet.java
 * Copyright (C) 2020 2020-11-29 15:44 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class BookManagerServlet extends BaseServlet
{
    private BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查出所有图书数据并显示
        List<Book> list = bookService.getAll();
        //图书查出以后交给页面book_manager.jsp
        req.setAttribute("list", list);
        //交给页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
   
    //图书添加
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.将提交的图书信息封装为book对象,表单的name应该和对象的属性一一对应
        Book book = WebUtils.param2bean2(req, new Book());
        System.out.println("add:"+book);
        //2.将图书保存到数据库
        boolean b = bookService.add(book);

        if (b) {
            //3.保存成功，重回列表页面，列表显示
            resp.sendRedirect(req.getContextPath()+"/manager/BookManagerServlet?method=list");
        }
    }
}

