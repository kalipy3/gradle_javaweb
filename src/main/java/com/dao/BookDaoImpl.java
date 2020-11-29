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
        String sql = "insert into bs_book(title,author,price,sales,stock,img_path) value(?,?,?,?,?,?)";
        int update = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());

        return update > 0;
    }

    @Override
    public boolean delBook(Book book) {
        String sql = "delete from bs_book where id=?";
        int update = update(sql, book.getId());

        return update > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        String sql = "update bs_book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        //book 修改后的样子
        int update = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());

        return update > 0;
    }

    @Override
    public Book getBook(Book book) {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where id=?";
        return getBean(sql, book.getId());
    }

    @Override 
    public List<Book> getPageList(int index, int size) {
        String sql = "select id, title, author, price, sales, stock, img_path imgPath from bs_book limit ?,?";
        return getBeanList(sql, index, size);
    }
	
    public BookDaoImpl() {
		
	}
}

