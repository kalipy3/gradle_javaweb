<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>scope2.jsp 以下是各个域中的数据</h1>
        pageContext: <%=pageContext.getAttribute("pageUser") %>
        request: <%=request.getAttribute("reqUser") %>
        session: <%=session.getAttribute("sessUser") %>
        application: <%=application.getAttribute("appUser") %>
    </body>
</html>
