<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>图书管理</title>
        <%@include file="/include/base.jsp" %>

        <script type="text/javascript">
                $(function(){
                    $(".delBtn").click(function(){
                        //alert("删除");
                        //this代表当前被点击的a
                        //parent()-->td    parent()-->tr
                        var td = $(this).parent().parent().children(":first");
                        if (!confirm("确认删除【"+td.text()+"】吗?")) {
                            //用户点击取消
                            return false;
                        }
                    });
                });
        </script>
    </head>
    <body>
        <div id="header">
            <h1>图书管理系统</h1>
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
                    <td><a href="manager/BookManagerServlet?method=getBook&id=${book.id}&m=update">修改</a></td>
                    <td><a class="delBtn" href="manager/BookManagerServlet?method=delete&id=${book.id}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="pages/manager/book_edit.jsp?m=add">添加图书</a></td>
            </tr>
        </table>
    </body>
</html>
