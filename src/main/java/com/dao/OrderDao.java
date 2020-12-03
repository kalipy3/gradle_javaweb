package com.dao;

import java.util.List;

import com.bean.Order;
/*
 * OrderDao.java
 * Copyright (C) 2020 2020-12-03 16:00 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

//操作订单的dao
public interface OrderDao
{
    //保存订单
    public int saveOrder(Order order);

    //修改订单状态
    public int updateStatus(Order order);

    //获取所有的订单(管理员用)
    public List<Order> getOrderList();

    //获取某个用户的所有订单
    public List<Order> getOrderByUserId(Integer userId);
}

