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
        pageContext.setAttribute("stu", stu);
        request.setAttribute("stu", stu);
        session.setAttribute("stu", stu);
        application.setAttribute("stu", stu);
        %>
        <c:set property="username" value="hanser" target="${stu}"></c:set>
        <%=stu.getUsername()%>

        <hr/>
        <c:remove var="stu" scope="page"/>
        page:${pageScope.stu.username}<br/>
        request:${requestScope.stu.username}<br/>
        session:${sessionScope.stu.username}<br/>
        application:${applicationScope.stu.username}<br/>

        <hr/>
        <c:if test="${stu.username != null}" scope="page" var="flag">
            <h1>我是c:if里面</h1>
        </c:if>
        ${flag}

        <hr/>
        <c:if test="${stu.age > 18}">
            <h2>你的年龄大于18岁</h2>
        </c:if>
        <c:if test="${stu.age <= 18}">
            <h2>你的年龄小于18岁</h2>
        </c:if>
    </body>
</html>
