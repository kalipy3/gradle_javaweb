package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.bean.Order;
import com.bean.User;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import com.servlet.BaseServlet;
import com.utils.WebUtils;

/*
 * OrderManagerServlet.java
 * Copyright (C) 2020 2020-12-03 22:35 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderManagerServlet extends BaseServlet 
{
    OrderService orderService = new OrderServiceImpl();
    
    //列出所有订单(管理员用)
    protected void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        List<Order> list = orderService.getAllOrder();
        req.setAttribute("orders", list);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }
}

