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

public class MyEclipseServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        System.out.println("doget...");
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        System.out.println("dopost...");
        //1.响应请求
        PrintWriter writer = resp.getWriter();
        writer.write("Hello HttpServlet..");
        //2.重定向
        resp.sendRedirect("success.html");
    }

	public MyEclipseServlet() {
        System.out.println("我是构造方法");
		
	}
}

