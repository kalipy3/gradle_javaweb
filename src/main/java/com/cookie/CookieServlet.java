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

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie[] cookies = req.getCookies();
        //拿到要删除的cookie
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                cookie = c;
            }
        }

        //负数 不保存cookie 即使发给浏览器，浏览器也不会保存
        //正数 cookie的最大存在时间 秒
        //0 表示删除cookie
        cookie.setMaxAge(0);
        resp.addCookie(cookie);//这句不能少
        resp.getWriter().write("cookie已删除");
    }
    
    protected void persist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                cookie = c;
            }
        }

        //修改cookie的存活时间
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);//这句不能少
        resp.getWriter().write("cookie设置的存活时间是一个小时,一个小时后过期..");
    }
    
    protected void setpath(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie cookie = new Cookie("mycookie", "mycookie_value");
        //表示访问hello下的资源会被带上,/代表服务器的根目录 根目录指127.0.0.1:8080/ 而不是项目的根目录
        //告诉浏览器访问哪些路径带上此cookie
        cookie.setPath("/hello");
        //默认访问当前项目下的所有资源都会带上
        resp.addCookie(cookie);

        resp.getWriter().write("cookie的路径被修改了..");
    }
}

