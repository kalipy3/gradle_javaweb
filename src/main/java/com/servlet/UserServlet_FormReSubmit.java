package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * UserServlet_FormReSubmit.java
 * Copyright (C) 2020 2020-12-01 21:59 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class UserServlet_FormReSubmit extends HttpServlet 
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String username = req.getParameter("username");
        System.out.println(username + "已经保存到数据库");
        req.getRequestDispatcher("/success_formresubmit.jsp").forward(req, resp);
    }
}

