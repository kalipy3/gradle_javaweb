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

	public BookDaoTest() {
		
	}
}

