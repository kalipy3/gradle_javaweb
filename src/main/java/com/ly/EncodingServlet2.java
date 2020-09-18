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

public class EncodingServlet2 extends HttpServlet 
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {

        //当我们在表单中填写中文的时候获取到的也是乱码
        //1.post乱码原因
        //浏览器将数据编码并提交上来，但是服务器并知道编码规则
        //解决：
        //  让服务器知道编码规则即可，重新设置请求的编码格式
       req.setCharacterEncoding("utf-8");
       String username = req.getParameter("username");
       System.out.println(username);

        //2.get也会乱码
        //原因：
        //  浏览器将地址栏也编码了，服务器不知道，而且8080端口接收到url后，已经按照默认方式处理完了
        //  所以在req.setCharacterEncoding("utf-8");也没用
        //  解决：
        //      修改tomcat的server.xml配置文件 在8080端口处添加URIEncoding="utf-8"


        //解决响应乱码
        resp.addHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("请求成功");
    }

}

