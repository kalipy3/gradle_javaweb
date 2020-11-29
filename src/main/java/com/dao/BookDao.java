package com.dao;

import java.util.List;
import com.bean.Book;

/*
 * BookDao.java
 * Copyright (C) 2020 2020-11-29 01:01 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public interface BookDao
{
    //获取所有图书
    public List<Book> getAllBook();

    //添加一本图书
    public boolean addBook(Book book);

    //删除一本书
    //@param book 要删除的图书，id
    public boolean delBook(Book book);

    //修改一本书
    //@param book 要修改的图书，book是修改后的样子
    public boolean updateBook(Book book);

    //根据图书的id查找图书
    //@param book 包含图书的id
    public Book getBook(Book book);

    //分页查找图书的方法
    //@param index
    //@param size
    public List<Book> getPageList(int index, int size);

    public int getTotalCount();
}

