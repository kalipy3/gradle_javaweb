<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>书城首页</title>
        <%@include file="/include/base.jsp" %>
    </head>
    <body>
        <h1>网上书城</h1>
        <a href="manager/BookManagerServlet?method=page">图书管理后台</a>
        <book_cond>
            <!-- form默认是get提交 这里必须post，不然method=pageByPrice不会带上 -->
            <form action="client/BookClientServlet?method=pageByPrice" method="post">
                价格：<input type="text" name="min" value="${param.min}">元-
                <input type="text" name="max" value="${param.max}">元
                <button>查询</button>
            </form>
        </book_cond>
        
        <div style="text-align: center">
            <span>您的购物车中有
                <c:out value="${cart.totalCount}" default="0"></c:out>
                件商品</span>
            <div>
                <c:if test="${!empty title}">
                    您刚刚将<span style="color: red">
                        ${title}
                    </span>加入到购物车
                </c:if>
                <c:if test="${empty title}">
                    <span>&nbsp;</span>
                </c:if>
            </div>
        </div>

        <div id="book" style="display:flex">
            <c:forEach items="${page.pageData}" var="book">
                <div class="b_list">
                    <div class="img_div">
                        <img class="book_img" src="${book.imgPath}" alt="">
                    </div>
                    <div class="book_info">
                        <div class="book_name">
                            <span>书名:</span>
                            <span>${book.title}</span>
                        </div>
                        <div class="book_author">
                            <span>作者:</span>
                            <span>${book.author}</span>
                        </div>
                        <div class="book_price">
                            <span>价格:</span>
                            <span>${book.price}RMB</span>
                        </div>
                        <div class="book_sales">
                            <span>销量:</span>
                            <span>${book.sales}</span>
                        </div>
                        <div class="book_amount">
                            <span>库存:</span>
                            <span>${book.stock}</span>
                        </div>
                        <div class="book_add">
                            <a style="color: blue;" href="client/CartServlet?method=add&id=${book.id}">加入购物车</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <%@include file="/include/page.jsp" %>
    </body>
</html>
