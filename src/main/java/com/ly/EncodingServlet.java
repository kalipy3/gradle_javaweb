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

public class EncodingServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
  
        

        //法一：
        //告诉浏览器我传输的数据的内容类型
        //resp.setContentType("text/html");
        //告诉浏览器编码
        //resp.setCharacterEncoding("utf-8");
        
        //法二：
        resp.addHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("请求成功");
    }

}

