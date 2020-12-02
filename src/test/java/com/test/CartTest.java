package com.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.bean.Book;
import com.bean.Cart;
/*
 * CartTest.java
 * Copyright (C) 2020 2020-12-02 17:47 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class CartTest
{
    Book book1 = new Book(1, "西游记1", "", 12.3, 100, 100, "") ;
    Book book2 = new Book(2, "西游记2", "", 182.3, 100, 100, "") ;
    Book book3 = new Book(3, "西游记3", "", 162.3, 100, 100, "") ;
    Book book4 = new Book(4, "西游记4", "", 152.3, 100, 100, "") ;
    Book book5 = new Book(5, "西游记5", "", 2.3, 100, 100, "") ;
   
    @Test
	public void test1() {
        System.out.println("test1-----------------------------");
		Cart cart = new Cart();
        cart.addBook2Cart(book1);
        cart.addBook2Cart(book2);
        cart.addBook2Cart(book3);
        System.out.println("当前总计"+cart.getTotalCount()+"本书");
        System.out.println("当前总价"+cart.getTotalMoney());
        System.out.println("当前购物车中的项目:"+cart.getAllItems());
        
        System.out.println("删除之后-----------------------------");
        cart.deleteItem(book1.getId().toString());
        cart.deleteItem(book2.getId().toString());
        System.out.println("当前总计"+cart.getTotalCount()+"本书");
        System.out.println("当前总价"+cart.getTotalMoney());
        System.out.println("当前购物车中的项目:"+cart.getAllItems());
        
        System.out.println("修改之后-----------------------------");
        cart.updateCount(book3.getId().toString(), "3");
        System.out.println("当前总计"+cart.getTotalCount()+"本书");
        System.out.println("当前总价"+cart.getTotalMoney());
        System.out.println("当前购物车中的项目:"+cart.getAllItems());
	}

    @Test
    public void test2() {
        System.out.println("test2-----------------------------");
        //大数运算问题
        int i = 1;
        for (int j = 1; j < 21; j++) {
            i *= j;
        }
        System.out.println(i);

        //浮点运算问题
        double a = 0.01, b = 0.02;
        System.out.println("0.01+0.02="+(a+b));
        
        double c = 0.01, d = 0.06;
        System.out.println("0.01+0.06="+(c+d));
        
        BigDecimal bigDecimal1 = new BigDecimal(c+"");//浮点数要用String类型的构造器，不能传double类型
        BigDecimal bigDecimal2 = new BigDecimal(d+"");
        System.out.println("big-->0.01+0.06="+(bigDecimal1.add(bigDecimal2)));
    }
    
    @Test
    public void test3() {
        System.out.println("test3-----------------------------");
        BigDecimal bigDecimal = new BigDecimal(1);
        for (int j = 1; j < 20000; j++) {
            bigDecimal = bigDecimal.multiply(new BigDecimal(j));
        }
        System.out.println(bigDecimal);
    }
}

