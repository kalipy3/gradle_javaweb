<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="250.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%=config.getServletName()
        %>

        <%
        response.getWriter().write("我是中文1");
        %>
        <%out.write("<br/>你好1"); %>
        <%out.write("<br/>你好2"); %>
        <%out.write("<br/>你好3"); %>
        <%
        response.getWriter().write("我是中文2");
        %>
    </body>
</html>
