<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>购物车</title>
        <%@include file="/include/base.jsp" %>
        <%@include file="/include/user-info.jsp" %>
        <script type="text/javascript">
            $(function(){
                $(".delBtn").click(function(){
                    var textEle = $(this).parents("tr").children(":first").text();
                    if (!confirm("确定删除【"+textEle+"】吗?")) {
                        //取消删除
                        return false;
                    } 
                });
                //jquery.js的 当input框内容发生变化，执行
                $(".changeinput").change(function(){
                    alert("gg");
                    //发送请求，修改数量
                })
            });
        </script>
    </head>
    <body>
        <div id="main">
            <!-- el表达式会自动调用getAllItems方法 -->
            <c:if test="${empty cart.allItems}">
                <h1>购物车为空，<a href="index.jsp">赶紧购买吧</a></h1>
            </c:if>
            <c:if test="${!empty cart.allItems}">
                <table>
                    <tr>
                        <td>商品名称</td>
                        <td>数量</td>
                        <td>单价</td>
                        <td>金额</td>
                        <td>操作</td>
                    </tr>
                    <!-- el表达式会自动调用getAllItems方法 -->
                    <c:forEach items="${cart.allItems}" var="item">
                        <tr>
                            <td>${item.book.title}</td>
                            <td>
                                <input class="changeinput" type="text" style="width: 30px" name="count" value="${item.count}">
                            </td>
                            <td>${item.book.price}</td>
                            <td>${item.totalPrice}</td>
                            <td><a class="delBtn" href="client/CartServlet?method=delete&id=${item.book.id}">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="cart_info">
                    <span class="cart_span">购物车中共有${cart.totalCount}<span class="b_count>"</span>件商品</span>
                    <span class="cart_span">总金额<span class="b_price">${cart.totalMoney}</span>元</span>
                    <span class="cart_span"><a href="">清空购物车</a></span>
                    <span class="cart_span"><a href="">去结账</a></span>
                </div>
            </c:if>
        </div>
    </body>
</html>
