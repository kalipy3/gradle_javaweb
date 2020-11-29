package com.service;
import java.util.List;

import com.bean.Book;
import com.bean.Page;
import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.service.BookService;
/*
 * BookServiceImpl.java
 * Copyright (C) 2020 2020-11-29 15:32 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class BookServiceImpl implements BookService
{
    private BookDao bd = new BookDaoImpl();

    @Override
    public boolean add(Book book) {
        return bd.addBook(book);
    }
    
    @Override
    public boolean update(Book book) {
        return bd.updateBook(book);
    }
    
    @Override
    public boolean delete(Book book) {
        return bd.delBook(book);
    }
    
    @Override
    public Book getOne(Book book) {
        return bd.getBook(book);
    }
    
    @Override
    public List<Book> getAll() {
        return bd.getAllBook();
    }
    
    @Override
    public Page<Book> getPage(String pageNo, String pageSize) {
        //1.将用户传入的数据先封装部分
        Page/*<Book>*/ page = new Page<Book>();
        //将用户传入的数据转型并封装,设置默认值
        int pn = 1;
        int ps = page.getPageSize();
        try {
            pn = Integer.parseInt(pageNo);
            ps = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        page.setPageNo(pn);
        page.setPageSize(ps);
        //2.因为要使用totalCount也即是当前总记录数，所以还想要查数据库
        return 
    }

    public BookServiceImpl() {

    }
}

