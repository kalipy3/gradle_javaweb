package com.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * TestServlet.java
 * Copyright (C) 2020 2020-12-04 22:24 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class TestServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
        //转发到test.jsp页面
        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}

