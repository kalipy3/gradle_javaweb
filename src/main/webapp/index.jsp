<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <!-- jsp脚本片段 java代码片段 -->
        <%
        System.out.println("hello jsp");
        out.write("你好");
        %>

        <!-- jsp表达式 在页面输出内容 -->
        <%= "HelloWorld"%>
        <%=new Date() %>

        <h1>我是jsp</h1>
    </body>
</html>
