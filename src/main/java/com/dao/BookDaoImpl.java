package com.dao;
import java.util.List;

import com.bean.Book;
import com.dao.BaseDao;
import com.dao.BookDao;
/*
 * BookDaoImpl.java
 * Copyright (C) 2020 2020-11-29 14:15 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class BookDaoImpl extends BaseDao<Book> implements BookDao
{

    @Override
    public List <Book> getAllBook() {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book";
        //返回所有图书
        return getBeanList(sql);
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean delBook(Book book) {
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public Book getBook(Book book) {
        return null;
    }
	
    public BookDaoImpl() {
		
	}
}

