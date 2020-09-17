package com.ly;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * ContextServlet.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 * 研究ServletContext
 *
 * 从ServletContext里面获取的
 */

public class ContextServlet implements Servlet 
{
    private ServletConfig config;

    public ContextServlet() {

    }

    @Override
    public void destroy() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();

        ServletContext servletContext = servletConfig.getServletContext();
        
        //研究ServletContext对象
        //1.是什么？一个web应用对应一个ServletContext.代表整个web项目
        //2.功能：
        //  获取web项目配置信息，获取web项目的初始化参数。
        String user = servletContext.getInitParameter("user");
        String username = servletContext.getInitParameter("username");
        System.out.println(user+"-->"+username);
        //2.获取web的项目路径
        String path = servletContext.getContextPath();
        System.out.println(path);
        //3.获取资源的真实路径
        //虚拟路径：网络访问使用的是虚拟路径
        //真实路径：文件的磁盘路径
        String realPath = servletContext.getRealPath("/index.html");
        System.out.println(realPath);
    }
}

