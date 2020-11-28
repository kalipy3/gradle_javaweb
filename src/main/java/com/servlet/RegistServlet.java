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
import com.utils.WebUtils;

/*
 * MyEclipseServlet.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class RegistServlet extends HttpServlet 
{
    private UserService us = new UserServiceImpl();

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = WebUtils.param2bean(req, new User());

        boolean b = us.regist(new User(null, username, password, email));
        if (b) {
            //注册成功 返回成功页面 重定向
            resp.sendRedirect(req.getContextPath() 
                    + "/pages/user/regist_success.jsp");
        } else {
            //注册失败 返回注册页面 转发
            req.setAttribute("msg", "用户已存在");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}

