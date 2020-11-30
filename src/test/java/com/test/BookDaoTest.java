/*
 * BookDaoTest.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.test;

import java.util.List;

import org.junit.Test;

import com.bean.Book;
import com.bean.Page;
import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.service.BookService;
import com.service.BookServiceImpl;

public class BookDaoTest
{
    BookDao bd = new BookDaoImpl();
    //@Test 
    //public void test() {
    //    List<Book> list = bd.getAllBook(); 
    //    System.out.println(list);
    //}

    ////添加图书
    //@Test 
    //public void test2() {
    //    Book book = new Book(null, "c语言", "郝斌", 50.12, 0, 200, null);
    //    boolean b = bd.addBook(book);
    //    System.out.println(b);
    //}

    ////删除
    //@Test 
    //public void test3() {
    //    Book book = new Book();
    //    book.setId(2);
    //    boolean b = bd.delBook(book);
    //    System.out.println(b);
    //}

    ////修改图书
    //@Test
    //public void test4() {
    //    Book book = new Book(3, "c", "kalipy", 500, 0, 200, null);
    //    boolean b = bd.updateBook(book);
    //    System.out.println(b);
    //}

    ////获取一本图书
    //@Test
    //public void test5() {
    //    Book b = new Book();
    //    b.setId(6);
    //    Book book = bd.getBook(b);
    //    System.out.println(book);//不是b
    //}

	public BookDaoTest() {
		
	}

    @Test
    public void test7() {
        BookService bs = new BookServiceImpl();
        Page<Book> page = bs.getPageByPrice("1", "4", "2000", "1000");
        System.out.println("test7--pageData:"+page.getPageData());
        System.out.println("test7--pageNo:"+page.getPageNo());
        System.out.println("test7--pageSize:"+page.getPageSize());
        System.out.println("test7--TotalCount:"+page.getTotalCount());
        System.out.println("test7--TotalPage:"+page.getTotalPage());
    }
}

