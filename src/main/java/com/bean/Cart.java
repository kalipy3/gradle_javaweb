package com.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.bean.CartItem;

/*
 * Cart.java
 * Copyright (C) 2020 2020-12-02 15:42 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

//购物车，保存了每个购物项的信息，还封装了对购物车的操作方法
public class Cart
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
        double money = 0.0;
        for (CartItem cartItem : list) {
            //将每项的总金额加起来
            money += cartItem.getTotalPrice();
        }
        return money;
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

}

