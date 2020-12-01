<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form action="CookieLoginServlet">
            用户名：<input name="username" value="${cookie.username.value}" type="text">
            密码：<input name="pwd" value="" type="password">
            <button>登录</button>
        </form>
    </body>
</html>
