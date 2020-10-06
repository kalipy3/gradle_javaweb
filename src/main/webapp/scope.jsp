<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%
            //给pageContext域中设置内容
            pageContext.setAttribute("pageUser", "pageName");
            //给request域中设置内容
            request.setAttribute("reqUser", "reqName");
            //给session域中设置内容
            session.setAttribute("sessUser", "sessName");
            //给application域中设置内容
            application.setAttribute("appUser", "appName");
        %>

        <jsp:forward page="scope2.jsp"></jsp:forward>
        <h1>scope.jsp 以下是各个域中的数据</h1>
        pageContext: <%=pageContext.getAttribute("pageUser") %>
        request: <%=request.getAttribute("reqUser") %>
        session: <%=session.getAttribute("sessUser") %>
        application: <%=application.getAttribute("appUser") %>
        <a href="scope2.jsp">去scope2看效果</a>
    </body>
</html>
