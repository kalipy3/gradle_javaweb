<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <%@include file="/include/base.jsp" %>
</head>
<body>
    <h1>欢迎登录</h1>

    <!-- 如果没有错误消息，显示请输入用户名密码，否则显示错误提示消息 -->
    <%=request.getAttribute("msg")==null?"请输入用户名密码":request.getAttribute("msg") %>

    <form action="user/LoginServlet" method="post">
      <label>用户名：</label>
      <input type="text" name="username" />
      <label>密码：</label>
      <input type="password" name="password" />
      <input type="submit" value="登录">
    </form>
</body>
</html>
