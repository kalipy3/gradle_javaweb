package com.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.BaseServlet;

/*
 * CookieServlet.java
 * Copyright (C) 2020 2020-11-30 23:44 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class CookieServlet extends BaseServlet
{
    //创建cookie
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //服务器创建一个cookie
        Cookie cookie = new Cookie("username", "acher");
        Cookie cookie2 = new Cookie("pwd", "123456");

        //把cookie发送给浏览器
        resp.addCookie(cookie);
        resp.addCookie(cookie2);

        resp.getWriter().write("cookie发给你了..");
    }
    
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //从请求头里获取到所有的cookie
        Cookie[] cookies = req.getCookies();
        
        //遍历取出cookie的key和value 一个cookie就是一个key-value
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            resp.getWriter().write("cookie的name:"+name);
            resp.getWriter().write("<br/>cookie的value:"+value);
        }
    }
}

