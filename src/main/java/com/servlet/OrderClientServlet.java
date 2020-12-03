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
 * OrderClientServlet.java
 * Copyright (C) 2020 2020-12-03 20:58 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class OrderClientServlet extends BaseServlet 
{
    OrderService orderService = new OrderServiceImpl();
    protected void checkout(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        HttpSession session = req.getSession();
        //获取已经登录的用户
        User loginUser = WebUtils.getLoginUser(req);
        //2.登录则结算
        if (loginUser != null) {
            //代表用户已经登录i
            Cart cart = WebUtils.getCart(req);
            //结算 返回订单号
            String orderid = orderService.checkout(cart, loginUser);
            session.setAttribute("orderId", orderid);
            resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
        } else {
            //3.否则直接返回登录页面登录
            req.setAttribute("msg", "此操作需要登录，请先登录!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
    
    //列出用户当前所有订单
    protected void list(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        //获取已经登录的用户
        User user = WebUtils.getLoginUser(req);
        List<Order> list = orderService.getMyOrders(user.getId());
        //域中保存了该用户的所有订单
        req.setAttribute("orders", list);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }
}

