package com.dao;
import java.util.List;

import com.bean.Book;
import com.bean.Page;
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
    
    //根据图书价格查询图书
    @Override 
    public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice) {
        String sql = "select id, title, author, price, sales, stock, img_path imgPath from bs_book where price between ? and ? limit ?,?";
        return getBeanList(sql, minPrice, maxPrice, index, size);
    }
	
    public BookDaoImpl() {
		
	}

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from bs_book";
        Object object = getSingleValue(sql);
        int parseInt = 0;
        try {
        parseInt = Integer.parseInt(object.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return parseInt;
    }

    @Override
    public int getTotalCountByPrice(double minPrice, double maxPrice) {
        String sql = "select count(*) from bs_book where price between ? and ?";
        Object object = getSingleValue(sql, minPrice, maxPrice);
        int i = 0;
        try {
            i = Integer.parseInt(object.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return i;
    }
}

