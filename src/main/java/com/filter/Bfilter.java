package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * Bfilter.java
 * Copyright (C) 2020 2020-12-04 21:41 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Bfilter implements Filter
{
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是Bfilter.doFilter()..");
        chain.doFilter(req, resp);
    }
}


