<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <div id="header">
            <span>我的订单</span>
            <%@include file="/include/user-info.jsp" %>
        </div>

        <div id="main">
            <c:if test="${empty orders}">
                你还没有订单，<a href="index.jsp">赶紧去买东西吧</a>
            </c:if>
            <c:if test="${!empty orders}">
                <table>
                    <tr>
                        <td>订单号</td>
                        <td>日期</td>
                        <td>金额</td>
                        <td>状态</td>
                        <td>详情</td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.createDate}</td>
                            <td>${order.totalMoney}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.status==0}">
                                        未发货
                                    </c:when>
                                    <c:when test="${order.status==1}">
                                        已发货
                                        <a href="#">确认收货</a>
                                    </c:when>
                                    <c:when test="${order.status==2}">
                                        交易完成
                                    </c:when>
                                </c:choose>
                            <td>
                                <a href="">查看详情</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>
