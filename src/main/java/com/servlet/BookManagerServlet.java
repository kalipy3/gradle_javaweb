package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.bean.Page;
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
    
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入分页逻辑");
        //用户点击图书管理显示部分数据,页码应该是用户传进来的
        String pn = req.getParameter("pn");
        Page<Book> page = bookService.getPage(pn, "4");
        //将第一页的数据放到页面显示
        req.setAttribute("page", page);
        //交给页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //显示图书列表 现在没用了，我们用page方法显示部分数据
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
            resp.sendRedirect(req.getContextPath()+"/manager/BookManagerServlet?method=page");
        }
    }
    
    //
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String pn = req.getParameter("pn");
        //System.out.println("当前停留的页码:"+pn);
        
        //referer代表从哪里来
        String string = req.getHeader("Referer");
        System.out.println("delete--Referer:"+string);
        //封装要删除的book
        Book book = WebUtils.param2bean2(req, new Book());
        //调用删除方法
        bookService.delete(book);
        System.out.println("delete:"+book);
        //回到列表显示
        resp.sendRedirect(string);
    }
    
    //查出某本图书的详细信息，显示到页面
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getBook--页码:"+req.getParameter("pn"));
        //按照id查出某本图书
        Book book = WebUtils.param2bean2(req, new Book());
        System.out.println("getBook:"+book);
        //获取详细信息
        Book one = bookService.getOne(book);
        //回到编辑页面进行显示
        req.setAttribute("book", one);
        //转发到页面进行显示
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
   
    //修改图书
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pn = req.getParameter("pn");
        //封装修改的图书信息
        Book book = WebUtils.param2bean2(req, new Book());
        System.out.println("update:"+book);
        //由于修改和添加操作，封装出的book,id有差别，所以可以通过id就直接断定是add添加操作还是update修改操作
        if (book.getId() == 0) {
            //添加图书
            bookService.add(book);
        } else {
            //修改图书
            bookService.update(book);
        }
        //返回列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/BookManagerServlet?method=page&pn=" + pn);
    }
}

