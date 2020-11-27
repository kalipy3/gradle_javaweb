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
//处理所有和用户相关的请求
//Servlet implements class UserServlet
public class UserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
    
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        //处理用户请求 login--UserServlet regist--UserServlet
        //if(登录请求) {
        //  调用用户登录
        //} else if(注册请求) {
        //  调用用户注册
        //} else if(修改密码) {
        //  调用修改密码
        //}
        String method = req.getParameter("method");
        System.out.println(method);
        //getDeclaredMethod(方法名，参数列表)
        try {
            Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method2.setAccessible(true);
            //invoke(对象，参数)
            method2.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //if ("regist".equals(method)) {
        //    //认为当前是注册请求
        //    regist(req, resp);
        //}
        //if ("login".equals(method)) {
        //    //认为当前是登录请求
        //    login(req, resp);
        //}
    }
    protected void regist(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

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
    protected void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
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

