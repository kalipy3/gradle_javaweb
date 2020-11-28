<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <c:set var="tip" scope="page" value="我是提示信息"></c:set>
        ${pageScope.tip}
    </body>
</html>
