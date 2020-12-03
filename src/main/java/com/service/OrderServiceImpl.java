package com.service;
/*
 * OrderServiceImpl.java
 * Copyright (C) 2020 2020-12-03 18:59 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderServiceImpl implements OrderService
{
    public OrderServiceImpl() {

    }

    //结账
    @Override
    public String checkout(Cart cart) {

    }

    //修改订单状态
    @Override
    public void updateStatus(String orderid, String status){}

    //获取所有订单，管理员用
    @Override
    public List<Order> getAllOrder(){}

    //获取某个用户的所有订单
    @Override
    public List<Order> getMyOrders(Integer userId){}
}

