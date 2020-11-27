package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/*
 * MyEclipseServlet.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class LoginServlet extends HttpServlet 
{
    private UserService us = new UserServiceImpl();

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = us.login(new User(1, username, password, "3069087972@qq.com"));
        if (user == null) {
            //登录失败 返回登录页面即可 转发
            req.setAttribute("msg", "用户名密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //登录成功 返回成功页面 重定向
            resp.sendRedirect(req.getContextPath() 
                    + "/pages/user/login_success.jsp");
        }
    }

}

