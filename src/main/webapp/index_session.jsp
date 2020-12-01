<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%
        session.setAttribute("sessAttr", "sessionValue");
        %>
        <!-- 重写url -->
        <!-- jstl可以代替 value指定要重写哪个url /代表当前项目 -->
        <c:url value="/session.jsp"></c:url>
        <a href="<c:url value="/session.jsp"></c:url>">去其它页面获取数据</a>
    </body>
</html>
