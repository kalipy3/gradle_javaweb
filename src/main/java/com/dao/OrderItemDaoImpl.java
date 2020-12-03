package com.dao;

import java.util.List;

import com.bean.OrderItem;
import com.dao.BaseDao;
import com.dao.OrderItemDao;

/*
 * OrderItemDaoImpl.java
 * Copyright (C) 2020 2020-12-03 16:37 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao
{
    public OrderItemDaoImpl() {

    }

    //获取某个订单的所有订单项
    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        String sql = "select id, title, count, price, total_price totalPrice, order_id orderId from bs_order_item where order_id=?";
        return getBeanList(sql, orderId);
    }

    //保存某个订单项
    @Override
    public int saveOrderItem(OrderItem item) {
        String sql = "insert into bs_order_item(title, count, price, total_price, order_id) values(?,?,?,?,?)";
        return update(sql, item.getTitle(), item.getCount(), item.getPrice(), item.getTotalPrice(), item.getOrderId());
    }
}

