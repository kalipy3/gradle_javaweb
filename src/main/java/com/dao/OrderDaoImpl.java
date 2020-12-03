package com.dao;

import java.util.List;

import com.bean.Order;
import com.dao.BaseDao;
import com.dao.OrderDao;
/*
 * OrderDaoImpl.java
 * Copyright (C) 2020 2020-12-03 16:12 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    public OrderDaoImpl() {

    }
    @Override 
    public int saveOrder(Order order) {
        String sql = "insert into bs_order(order_id, create_date, total_money, status, user_id) values(?,?,?,?,?)";
        int update = update(sql, order.getOrderId(), order.getCreateDate(), order.getTotalMoney(), order.getStatus(), order.getUserId());
        return update;
    }

    @Override 
    public int updateStatus(Order order) {
        String sql = "update bs_order set status=? where order_id=?";
        return update(sql, order.getStatus(), order.getOrderId());
    }

    //返回所有订单
    @Override 
    public List<Order> getOrderList() {
        //根据bean.Order的字段来去别名，为了让DB中的字段和bean中的字段对应起来
        String sql = "select order_id orderId, create_date createDate, total_money totalMoney, status, user_id userId from bs_order";
        return getBeanList(sql);
    }

    @Override 
    public List<Order> getOrderByUserId(Integer userId) {
        String sql = "select order_id orderId, create_date createDate, total_money totalMoney, status, user_id userId from bs_order where user_id=?";
        return getBeanList(sql, userId);
    }

}

