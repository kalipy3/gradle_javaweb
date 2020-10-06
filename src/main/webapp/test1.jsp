<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="250.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%!
        private String name="username";
        public void test1() {
            System.out.println("我是test1方法");
        }
        %>
        <%
        test1();
        int i = 10 / 0;
        %>
        <h1>我是test1.jsp</h1>
        <%= name%>
    </body>
</html>
