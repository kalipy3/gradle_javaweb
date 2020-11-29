package com.service;
import java.util.List;

import com.bean.Book;
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
    
	public BookServiceImpl() {
		
	}
}

