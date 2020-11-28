<!-- 写了include file="/include/base.jsp",依然要写这个jsp的标签，不然乱码 -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <%@include file="/include/base.jsp" %>
    </head>
    <body>
        <h1>欢迎登录</h1>
        <a href="pages/user/regist.jsp">立即注册</a>

        <!-- 如果没有错误消息，显示请输入用户名密码，否则显示错误提示消息 -->
        ${msg=null?"请输入用户名密码":msg}

        <form action="UserServlet" method="post">
            <input type="hidden" name="method" value="login">
            <label>用户名：</label>
            <input type="text" placeholder="请输入用户名" name="username" value="${param.username}" />
            <label>密码：</label>
            <input type="password" placeholder="请输入密码" name="password" />
            <input type="submit" value="登录">
        </form>
    </body>
</html>
