<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@ page language="java" import="com.test.Student" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <!-- jsp脚本片段 pageContext,request,session,application 在资源之间共享数据 -->
        <%
        Student stu = new Student(1, "张三", "password", "email", 18);
        pageContext.setAttribute("stu", stu);
        request.setAttribute("stu", "requestValue");
        session.setAttribute("stu", "sessionValue");
        application.setAttribute("stu", "appValue");
        String str = "你好";
        %>

        <hr/>
        jsp表达式：<%=str %><br/>
        el表达式：${str}<br/>
        <hr/>
        <%-- ${表达式内容} --%>
        使用el表达式获取域内容<br/>
        page:${pageScope.stu.username}<br/>
        request:${requestScope.stu}<br/>
        session:${sessionScope.stu}<br/>
        application:${applicationScope.stu}<br/>
    </body>
</html>
