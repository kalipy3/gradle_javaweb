package com.service;

import java.util.List;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.bean.OrderItem;
/*
 * OrderItemServiceImpl.java
 * Copyright (C) 2020 2020-12-03 19:02 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderItemServiceImpl implements OrderItemService
{
   OrderItemDao itemDao = new OrderItemDaoImpl();

    //保存订单项
    @Override
    public void saveItem(List<OrderItem> orderItem) {
        for (OrderItem orderItem2 : orderItem) {
            itemDao.saveOrderItem(orderItem2);
        }
    }

    //获取订单的所有订单项
    @Override
    public List<OrderItem> getOrderItems(String orderid) {
        return itemDao.getOrderItems(orderid);
    }
}

