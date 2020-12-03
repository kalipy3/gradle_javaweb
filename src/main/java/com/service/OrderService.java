package com.service;

import java.util.List;

import com.bean.Cart;
import com.bean.Order;

/*
 * OrderService.java
 * Copyright (C) 2020 2020-12-03 18:46 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public interface OrderService
{
    //结账
    public String checkout(Cart cart);

    //修改订单状态
    public void updateStatus(String orderid, String status);

    //获取所有订单，管理员用
    public List<Order> getAllOrder();

    //获取某个用户的所有订单
    public List<Order> getMyOrders(Integer userId);
}

