<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>图书管理</title>
        <%@include file="/include/base.jsp" %>
    </head>
    <body>
        <div id="header">
            <span>图书管理系统</span>
            <%@include file="/include/book-manager.jsp" %>
        </div>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${requestScope.list}" var="book">
            <!-- 这里是每一本书的详细信息 -->
                <tr>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.sales}</td>
                    <td>${book.stock}</td>
                    <td><a href="#">修改</a></td>
                    <td><a href="#">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
