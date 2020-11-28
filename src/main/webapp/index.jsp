<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.test.Student"%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%
        pageContext.setAttribute("msg", "<h1>提示信息</h1>");
        %>
        <c:out value="${msg}" default="hello" escapeXml="false"></c:out>
        <c:set var="tip" scope="request" value="${msg}"></c:set>
        ${requestScope.tip}

        <hr/>
        <%
        Student stu = new Student(1, "username", "password", "email", 12);
        %>
        <c:set property="username" value="yousa" target="<%=stu%>"></c:set>
        <%=stu.getUsername()%>
    </body>
</html>
