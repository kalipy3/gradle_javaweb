<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
        <%=
        response.encodeRedirectURL(request.getContextPath()+"/session.jsp")
        %>
        <a href="<%=
        response.encodeRedirectURL(request.getContextPath()+"/session.jsp")
        %>">去其它页面获取数据</a>
    </body>
</html>
