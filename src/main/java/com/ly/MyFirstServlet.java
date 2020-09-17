package com.ly;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * MyFirstServlet.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 * 一个Servlet只能处理一个指定请求
 * 应该指定servlet处理哪个请求
 * 需要在web.xml里配置servlet的详细信息
 */
public class MyFirstServlet implements Servlet {

    @Override
    public void destroy() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是地一个Servlet");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("HelloWorld");
    }
}

