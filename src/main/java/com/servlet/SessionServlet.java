package com.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.BaseServlet;

/*
 * SessionServlet.java
 * Copyright (C) 2020 2020-12-01 13:14 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class SessionServlet extends BaseServlet
{
    protected void get(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //判断session是否是新创建的
        boolean new1 = session.isNew();
        String id = session.getId();
        resp.getWriter().write("已经获取到session对象.."+new1);
        resp.getWriter().write("<br/>sessionid:"+id);
    }
    
    protected void save(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //给session域中保存数据
        String string = UUID.randomUUID().toString().substring(0, 8);
        session.setAttribute("user", string);

        resp.getWriter().write("session域中保存了数据:"+string);
    }
    
    protected void getvalue(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的内容
        HttpSession session = req.getSession();
        String attribute = (String) session.getAttribute("user");
        resp.getWriter().write("sesseion域中取出的数据"+attribute);
    }
    
    protected void time(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的内容
        HttpSession session = req.getSession();
        //获取session中最大存活时间 以秒为单位
        //session默认是30min,为什么新的会话开启会返回新session
        //因为获取session是根据cookie带来的jsessionid来获取的。而cookie是默认关闭浏览器了就销毁了
        //再来获取session,就会返回新的session,就得session还在，只是找不到了
        int interval = session.getMaxInactiveInterval();
        resp.getWriter().write("sesseion存活时间：" + interval);
    }
    
    protected void updatetime(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //1.传入负数：代表永不过期
        //2.传入正数：代表多少秒后过期，距离最后一次使用session的时间
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("sesseion将于3秒后过期");
    }
}

