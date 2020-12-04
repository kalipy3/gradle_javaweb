package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * HelloFilter.java
 * Copyright (C) 2020 2020-12-04 17:32 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

//过滤所有要访问vtuber页面的请求
//
//服务器的三大组件 运行在服务器上，服务器调用,所以要配置
//
//1.写一个现实
//2.在服务器配置filter要过滤哪些请求(web.xml)
public class HelloFilter implements Filter
{
    @Override 
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是hello.jsp的拦截器");
        String money = req.getParameter("money");
        if (money != null) {
            //带了钱，让她访问vtuber页面
            //将请求放行
            chain.doFilter(req, resp);
        } else {
            //没带钱，提示你回家要钱去
            resp.getWriter().write("no money, no mm!");
        }
    }

    @Override 
    public void destroy() {

    }
}


