package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bean.User;
import com.utils.WebUtils;

/*
 * LoginFilter.java
 * Copyright (C) 2020 2020-12-05 00:17 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class LoginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter已经启动");
        //验证用户是否登录，如果登录则放行，否则跳转到登录页面
        HttpServletRequest req2 = (HttpServletRequest) req;
        //获取已经登录的用户
        User user = WebUtils.getLoginUser(req2);
        if (user == null) {
            //未登录
            req.setAttribute("msg", "此操作需要登录，请先登录");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //已登录
            chain.doFilter(req, resp);
        }
    }
}


