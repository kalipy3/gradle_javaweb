package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * Afilter.java
 * Copyright (C) 2020 2020-12-04 18:52 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Afilter implements Filter 
{
    @Override 
    public void init(FilterConfig filterConfig) throws ServletException {
        //filterConfig是封装filter配置信息的对象
        String filterName = filterConfig.getFilterName();//filter的别名
        //filter的初始化参数
        String filterInitParameter = filterConfig.getInitParameter("username");
        //ServletContext-->对应我们的web应用
        ServletContext servletContext = filterConfig.getServletContext();
        //获取web初始化参数
        String initParameter = servletContext.getInitParameter("user");

        System.out.println("filter别名:" + filterName);
        System.out.println("filter初始化参数:" + filterInitParameter);
        System.out.println("获取servletContext:" + servletContext);
        System.out.println("通过servletContext对象获取全局初始化参数:" + initParameter);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是Afilter.doFilter()..1");
        chain.doFilter(req, resp);
        System.out.println("我是Afilter.doFilter()..2");
    }

    @Override 
    public void destroy() {

    }
}


