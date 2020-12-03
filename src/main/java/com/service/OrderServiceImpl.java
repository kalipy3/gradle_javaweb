package com.service;

import java.util.List;

import com.bean.Cart;
import com.bean.Order;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
/*
 * OrderServiceImpl.java
 * Copyright (C) 2020 2020-12-03 18:59 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderServiceImpl implements OrderService
{
    OrderDao orderDao = new OrderDaoImpl();

    //结账
    @Override
    public String checkout(Cart cart) {
        return null;
    }

    //修改订单状态
    @Override
    public void updateStatus(String orderid, String status){
        Order order = new Order();
        order.setOrderId(orderid);
        int parseInt = 0;
        try {
            parseInt = Integer.parseInt(status);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        order.setStatus(parseInt);
        orderDao.updateStatus(order);
    }

    //获取所有订单，管理员用
    @Override
    public List<Order> getAllOrder(){
        return orderDao.getOrderList();
    }

    //获取某个用户的所有订单
    @Override
    public List<Order> getMyOrders(Integer userId){
        return orderDao.getOrderByUserId(userId);
    }
}

