/*
 * BookDaoTest.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.test;

import java.util.List;

import org.junit.Test;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.bean.Book;

public class BookDaoTest
{
    BookDao bd = new BookDaoImpl();
    @Test 
    public void test() {
        List<Book> list = bd.getAllBook(); 
        System.out.println(list);
    }

    //添加图书
    @Test 
    public void test2() {
        Book book = new Book(null, "c语言", "郝斌", 50.12, 0, 200, null);
        boolean b = bd.addBook(book);
        System.out.println(b);
    }
	public BookDaoTest() {
		
	}
}

