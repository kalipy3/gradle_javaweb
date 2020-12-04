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
import com.bean.Constants;
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
        Cart cart = WebUtils.getCart(req);
        //获取已经登录的用户
        User loginUser = WebUtils.getLoginUser(req);
        //结算 返回订单号
        String orderid = orderService.checkout(cart, loginUser);
        session.setAttribute("orderId", orderid);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
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

    //确认收货
    protected void received(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String orderid = req.getParameter("orderid");
        orderService.updateStatus(orderid, Constants.DELIVERED+"");
        String refer = req.getHeader("referer");
        resp.sendRedirect(refer);
    }
}

