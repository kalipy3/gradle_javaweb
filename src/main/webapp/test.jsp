<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%
        int age = 2;
        if (age >= 18) {
        %>
            <h1>age>=18</h1>
        <%
        } else {
            out.print("<br/>编程从小孩抓起<br/>");
        }
        %>
        <h1>age<18</h1>
        <%
        out.print("就是不想写代码");
        %>
        <h1>我是test.jsp</h1>
    </body>
</html>
