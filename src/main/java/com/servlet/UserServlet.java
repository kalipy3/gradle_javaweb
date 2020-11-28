/*
 * UserServlet.java
 * Copyright (C) 2020 2020-11-27 21:48 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import com.utils.WebUtils;
//处理所有和用户相关的请求
//Servlet implements class UserServlet
//抽取BaseServlet以后
//UserServlet里面只需要编写相应的处理逻辑即可
public class UserServlet extends BaseServlet 
{
    private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
    
    protected void regist(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        User user = WebUtils.param2bean(req, new User());
        boolean b = us.regist(user);
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
    protected void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        User user2 = WebUtils.param2bean(req, new User());
        //User user = us.login(new User(1, username, password, "3069087972@qq.com"));
        User user = us.login(user2);
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

