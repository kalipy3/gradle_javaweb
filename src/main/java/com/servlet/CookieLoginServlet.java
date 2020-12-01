package com.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * CookieLoginServlet.java
 * Copyright (C) 2020 2020-12-01 12:32 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class CookieLoginServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        doPost(req, resp);
    }
   
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        if (username != null && pwd != null) {
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath()+"/success_cookie.jsp");
        }
    }
}

