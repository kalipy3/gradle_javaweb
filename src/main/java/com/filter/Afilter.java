package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是Afilter..doFilter()..");
    }

    @Override 
    public void destroy() {

    }
}


