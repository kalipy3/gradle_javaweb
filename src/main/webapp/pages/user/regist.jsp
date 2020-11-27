<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <%@include file="/include/base.jsp" %>
    </head>
    <body>
        <h1>注册页面</h1>

        <span class="errorMsg">
            <%=request.getAttribute("msg")==null?"请输入用户名":request.getAttribute("msg") %>
        </span>

        <form action="UserServlet?method=regist" method="get">
            <label>用户名：</label>
            <input type="text" name="username" placeholder="请输入用户名" value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>" />
            <label>密码：</label>
            <input type="password" placeholder="请输入密码" name="password" />
            <label>邮箱：</label>
            <input type="text" placeholder="请输入邮箱" name="email" value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>"/>
            <input type="submit" value="注册">
        </form>
    </body>
</html>
