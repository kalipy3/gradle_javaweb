<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>书城首页</title>
        <%@include file="/include/base.jsp" %>
    </head>
    <body>
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
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
