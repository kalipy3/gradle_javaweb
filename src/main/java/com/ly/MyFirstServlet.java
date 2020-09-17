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
 * Servlet的生命周期
 *
 * Servlet是跑在服务器上的
 *Tomcat服务器--->Servlet容器
 *
 * 生命周期：从出生到死亡的过程
 * Servlet的生命周期：Servlet从创建到销毁的过程
 *
 * 当我们第一次访问MyFirstServlet时：
 *  1.创建一个Servlet对象
 *  2.调用Init方法
 *  3.调用Service方法
 *
 *以后请求：
    4.只调用Service方法来处理请求 整个运行期间只创建一个servlet对象
        servlet是单实例，多线程运行。

  当项目从服务器卸载：
    5.服务器会调用destroy方法
 *
 */
public class MyFirstServlet implements Servlet {

    public MyFirstServlet() {
        System.out.println("我是MyFirstServlet构造方法..");
    }

    @Override
    public void destroy() {
        System.out.println("我是destroy方法..");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("我是getServletConfig方法..");
        return null;
    }

    @Override
    public String getServletInfo() {
        System.out.println("我是getServletInfo方法..");
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我是init方法..");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是service方法..");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("HelloWorld");
    }


}

