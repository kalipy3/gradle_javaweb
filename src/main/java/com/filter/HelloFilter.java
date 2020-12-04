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

//服务器管理的filter,生命周期
//从创建到销毁的过程
//1.创建-初始化
//      服务器一启动,项目加载进服务器,创建filter对象，并执行初始化,单例多线程
//2.每次拦截都执行
//      doFilter()
//3.销毁
//      项目从服务器中卸载
public class HelloFilter implements Filter
{
    @Override 
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init()..");
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter doFilter()..");
        String money = req.getParameter("money");
        if (money != null) {
            //带了钱，让她访问vtuber页面
            //将请求放行
            System.out.println("我是请求放行之前1..");
            chain.doFilter(req, resp);
            System.out.println("我是请求放行之后2..");
            resp.getWriter().write("HelloFilter..");
        } else {
            //没带钱，提示你回家要钱去
            //resp.getWriter().write("no money, no mm!");
        }
    }

    @Override 
    public void destroy() {
        System.out.println("filter destroy()..");
    }

    public HelloFilter() {
        System.out.println("filter HelloFilter()构造器..");
    }
}


