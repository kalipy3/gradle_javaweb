<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!-- 用户未登录显示这个 -->
<c:if test="${empty user}">
    <div>
        <a href="pages/user/login.jsp">登录</a>
        <a href="pages/user/regist.jsp">注册</a>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="manager/BookManagerServlet?method=page">后台管理</a>
    </div>
</c:if>

<!-- 用户登录成功显示这个 -->
<c:if test="${!empty user}">
    <div>
        <span>欢迎<span class="um_span">${user.username}</span>光临书城
        <a href="pages/cart/cart.jsp">购物车</a>
        </span> <a href="client/OrderClientServlet?method=list">我的订单</a>
        <a href="UserServlet?method=logout">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</c:if>
