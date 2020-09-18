package com.ly;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * MyEclipseServlet.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class LoginServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
   
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.length()>=6 && "123456".equals(password)) {
            //登录成功-->重定向到成功页面
            resp.sendRedirect("success/login-success.html");
        } else {
            //登录失败-->转发到失败页面
            req.getRequestDispatcher("success/login-error.html").forward(req,resp);
        }

    }

}

