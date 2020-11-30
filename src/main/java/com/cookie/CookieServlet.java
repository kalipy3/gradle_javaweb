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

        //把cookie发送给浏览器
        resp.addCookie(cookie);

        resp.getWriter().write("cookie发给你了..");
    }
}

