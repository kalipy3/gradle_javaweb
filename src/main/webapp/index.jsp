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
        pageContext.setAttribute("pageAttr", stu);
        request.setAttribute("requestAttr", "requestValue");
        session.setAttribute("sessionAttr", "sessionValue");
        application.setAttribute("appAttr", "appValue");
        %>

        <hr/>
        jsp表达式方式取出四个域中的内容：<br/>
        page:<%=((Student)pageContext.getAttribute("pageAttr")).getUsername() %><br/>
        request:<%=request.getAttribute("requestAttr") %><br/>
        session:<%=session.getAttribute("sessionAttr") %><br/>
        application:<%=application.getAttribute("appAttr") %><br/>
        <hr/>
        <%-- ${表达式内容} --%>
        使用el表达式获取域内容<br/>
        page:${pageAttr.username}<br/>
        request:${requestAttr}<br/>
        session:${sessionAttr}<br/>
        application:${appAttr}<br/>
    </body>
</html>
