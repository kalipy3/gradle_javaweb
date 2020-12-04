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
            <span>结算</span>
            <%@include file="/include/base.jsp" %>
            <%@include file="/include/user-info.jsp" %>
        </div>

        <div id="main">
            <h1>你的订单已结算，订单号为${orderId}</h1>
        </div>
    </body>
</html>
