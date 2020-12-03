package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Book;
import com.bean.Cart;
import com.bean.CartItem;
import com.bean.Order;
import com.bean.OrderItem;
import com.bean.User;
import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.service.BookService;
import com.service.BookServiceImpl;
import com.service.OrderItemService;
import com.service.OrderItemServiceImpl;
/*
 * OrderServiceImpl.java
 * Copyright (C) 2020 2020-12-03 18:59 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderServiceImpl implements OrderService
{
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemService itemService = new OrderItemServiceImpl();
    BookService bookService = new BookServiceImpl();

    //结账
    @Override
    public String checkout(Cart cart, User user) {
        //结账，把购物车里面的数据库封装并保存
        //1.封装订单对象
        //orderId需要使用算法生成
        long millis = System.currentTimeMillis();
        //生成订单号
        String orderId = millis + "" + user.getId();
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setOrderId(orderId);
        order.setTotalMoney(cart.getTotalMoney());
        order.setStatus(0);//0表示未发货
        order.setUserId(user.getId());

        //2.封装订单项
        List<CartItem> allItems = cart.getAllItems();
        //保存所有的订单项
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : allItems) {
            //封装一个订单项
            OrderItem item = new OrderItem(cartItem.getBook().getTitle(), cartItem.getCount(), cartItem.getBook().getPrice(), cartItem.getTotalPrice(), orderId);
            orderItems.add(item);
        }
        //3.保存订单
        orderDao.saveOrder(order);
        //4.保存订单项
        itemService.saveItem(orderItems);
        //5.修改相应库存,改图书，改每一项
        for (CartItem cartItem : allItems) {
            //获取详细信息
            Book book = cartItem.getBook();
            //修改库存和销量
            int count = cartItem.getCount();
            book.setStock(book.getStock()-count);
            book.setSales(book.getSales()+count);
            //更新信息
            bookService.update(book);
        }
        
        return orderId;
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

