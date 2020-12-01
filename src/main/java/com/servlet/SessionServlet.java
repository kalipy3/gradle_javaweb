package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.BaseServlet;

/*
 * SessionServlet.java
 * Copyright (C) 2020 2020-12-01 13:14 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class SessionServlet extends BaseServlet
{
    protected void get(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //判断session是否是新创建的
        boolean new1 = session.isNew();
        resp.getWriter().write("已经获取到session对象.."+new1);
    }
    
    protected void save(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //给session域中保存数据
        session.setAttribute("user", "umy");
        resp.getWriter().write("session域中保存了数据");
    }
    
    protected void getvalue(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的内容
        HttpSession session = req.getSession();
        String attribute = (String) session.getAttribute("user");
        resp.getWriter().write("sesseion域中取出的数据"+attribute);
    }
}

