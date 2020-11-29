package com.service;

import java.util.List;

import com.bean.Book;
import com.bean.Page;

/*
 * BookService.java
 * Copyright (C) 2020 2020-11-29 15:29 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
//图书业务逻辑
public interface BookService
{
    public boolean add(Book book);
    
    public boolean update(Book book);
    
    public boolean delete(Book book);
    
    public Book getOne(Book book);
    
    public List<Book> getAll();

    //返回分页数据
    public Page<Book> getPage(String pageNo, String pageSize);
}

