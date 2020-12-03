package com.dao;

import java.util.List;

import com.bean.OrderItem;
/*
 * OrderItemDao.java
 * Copyright (C) 2020 2020-12-03 16:05 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

//操作订单项dao
public interface OrderItemDao
{
    //获取某个订单的所有订单项
    public List<OrderItem> getOrderItems(String orderId);

    //保存某个订单项
    public int saveOrderItem(OrderItem item);
}

