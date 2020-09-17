/*
 * ConfigServlet.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.ly;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigServlet implements Servlet 
{
    private ServletConfig config = null;


	public ConfigServlet() {
		
    }

    /*
     * 销毁，销毁servlet对象
     * */
    @Override
    public void destroy() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return "ConfigServlet";
    }

    /*servlet的初始化方法，在servlet第一次被创建的时候调用
     * 只调用一次
     *
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //ServletConfig
        //1.是什么？是封装了servlet配置信息的对象，一个Servlet对象对应一个ServletConfig对象
        //封装的是当前的servlet的配置信息
        //2.功能：
        //  获取servlet的别名:getServletName()
        this.config = servletConfig;
        String servletName = config.getServletName();
        System.out.println(servletName);
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //  获取servlet的别名:getServletName()
        String servletName = config.getServletName();
        System.out.println(servletName);
        //获取servlet初始化参数
        String username = config.getInitParameter("username");
        System.out.println("初始化参数：username=="+username);
        //获取ServletContext对象，代表当前servlet的上下文。代表我当前的web项目信息
        ServletContext context = config.getServletContext();
        System.out.println(context);
    }
}

