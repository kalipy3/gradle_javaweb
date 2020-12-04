package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        StringBuffer url = req.getRequestURL();
        System.out.println("过来的请求uri:" + uri);
        System.out.println("过来的请求url:" + url.toString());
        System.out.println("我是Afilter..doFilter()..");

        //只拦截page下的所有jsp 虽然web.xml配置会拦截page下的所有
        if (uri.endsWith("jsp")) {
            System.out.println("jsp结尾的，我就拦截了");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override 
    public void destroy() {

    }
}


