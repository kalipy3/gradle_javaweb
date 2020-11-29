<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <%@include file="/include/base.jsp" %>
    </head>
    <body>
        <div id="header">
            <span>编辑图书</span>
            <%@include file="/include/book-manager.jsp" %>
        </div>
        <div id="main">
            <form action="manager/BookManagerServlet" method="post">
                <input type="hidden" name="method" value="${param.m}">
                <input type="hidden" name="id" value="${book.id}">
                <table>
                    <tr>
                        <td>名称</td>
                        <td>价格</td>
                        <td>作者</td>
                        <td>销量</td>
                        <td>库存</td>
                        <td colspan="2">操作</td>
                    </tr>
                    <tr>
                        <td><input name="title" type="text" value="${book.title}"/></td>
                        <td><input name="price" type="text" value="${book.price}"/></td>
                        <td><input name="author" type="text" value="${book.author}"/></td>
                        <td><input name="sales" type="text" value="${book.sales}"/></td>
                        <td><input name="stock" type="text" value="${book.stock}"/></td>
                        <td><input name="book_amount" type="submit" value="提交"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
