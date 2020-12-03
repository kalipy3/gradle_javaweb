package com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bean.Book;
import com.bean.CartItem;

/*
 * Cart.java
 * Copyright (C) 2020 2020-12-02 15:42 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

//购物车，保存了每个购物项的信息，还封装了对购物车的操作方法
public class Cart implements Serializable
{
    //保存的所有购物项
    private Map<Integer, CartItem> items = new LinkedHashMap<>(); 

    //总商品数
    private int totalCount;

    //所有项的总金额
    private double totalMoney;

	public Cart() {
		
    }

    public Map<Integer,CartItem> getItems() {
        return items;
    }

    //获取商品总数
    public int getTotalCount() {
        //获取购物车中的所有商品
        List<CartItem> list = getAllItems();
        int count = 0;
        for (CartItem cartItem : list) {
            count += cartItem.getCount();
        }
        return count;
    }

    //获取总金额
    public double getTotalMoney() {
        List<CartItem> list = getAllItems();
        BigDecimal money = new BigDecimal(0.0+"");
        for (CartItem cartItem : list) {
            //将每项的总金额加起来
            BigDecimal totalPrice = new BigDecimal(cartItem.getTotalPrice()+"");
            money = money.add(totalPrice);
        }
        return money.doubleValue();
    }

    @Override
    public String toString() {
        return "Cart{" +
            "items = " + getItems() +
            ", totalCount = " + getTotalCount() +
            ", totalMoney = " + getTotalMoney() +
            "}";
    }

    public Cart(Map<Integer,CartItem> items, int totalCount, double totalMoney) {
        this.items = items;
        this.totalCount = totalCount;
        this.totalMoney = totalMoney;
    }

    public List<CartItem> getAllItems() {
        //返回map中的所有值
        Collection<CartItem> values = items.values();
        return new ArrayList<>(values);
    }

    //定义操作购物车的其它方法
    //把图书添加到购物车
    public void addBook2Cart(Book book) {
        //判断是否有当前图书，有则数量加一
        CartItem item = items.get(book.getId());
        if (item == null) {
            //没有当前的购物项，则是第一次添加
            CartItem cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCount(1);
            
            //将购物项加入
            items.put(book.getId(), cartItem);
        } else {
            item.setCount(item.getCount()+1);
        }
    }

    //从购物车中删除某一项
    public void deleteItem(String bookid) {
        int id = Integer.parseInt(bookid);
        items.remove(id);
    }

    //修改数量
    //@param bookid 要修改的条目
    //@param count 修改后的数量
    public void updateCount(String bookid, String count) {
        int c = 1;
        int id = -1;
        try {
            c = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
        try {
            id = Integer.parseInt(bookid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        CartItem cartItem = items.get(id);
        cartItem.setCount(c);
    }

    //清空购物车
    public void clear() {
        //清空map
        items.clear();
    }

}

