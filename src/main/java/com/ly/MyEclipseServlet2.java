package com.ly;

import java.io.IOException;
import java.io.PrintWriter;

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

public class MyEclipseServlet2 extends HttpServlet 
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
   
        //1.获取请求数据 get post
        String username = req.getParameter("username");
        System.out.println(username);

        //2.获取多选框的内容
        String[] aihao = req.getParameterValues("aihao");
        for (String string : aihao) {
            System.out.println(string);
        }
        System.out.println(username+"爱好："+aihao);

        //3.获取请求头信息
        String userAgent = req.getHeader("User-Agent");
        System.out.println("请求头："+userAgent);
    }

}

