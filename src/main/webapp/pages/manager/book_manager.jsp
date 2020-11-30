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
                    $("#gotopage").click(function(){
                        //alert("Hello");
                        //用户输入了我们要去第几页
                        //1.获取到1用户输入的值
                        var pn = $("#pn_input").val();
                        //2.发送新的分页请求
                        window.location.href = "manager/BookManagerServlet?method=page&pn="+pn;
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
            <c:forEach items="${requestScope.page.pageData}" var="book">
            <!-- 这里是每一本书的详细信息 -->
                <tr>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.sales}</td>
                    <td>${book.stock}</td>
                    <td><a href="manager/BookManagerServlet?method=getBook&id=${book.id}">修改</a></td>
                    <td><a class="delBtn" href="manager/BookManagerServlet?method=delete&id=${book.id}&pn=${page.pageNo}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
            </tr>
        </table>

        <div id="page_nav">
            <a href="manager/BookManagerServlet?method=page&pn=1">首页</a>
            <c:if test="${page.hasPrev}">
                <a href="manager/BookManagerServlet?method=page&pn=${page.pageNo-1}">上一页</a>
            </c:if>

            <!-- 总页码在五页以内 -->
            <c:if test="${page.totalPage <= 5}">
                <!-- 给begin和end赋值 -->
                <c:set var="begin" value="1" scope="page"></c:set>
                <c:set var="end" value="${page.totalPage}" scope="page"></c:set>
            </c:if>
            <!-- 总页码在五页以上，才使用连续显示五页的逻辑 -->
            <c:if test="${page.totalPage > 5}">
                <!-- 当前页码小于3 -->
                <c:if test="${page.pageNo <= 3}">
                    <c:set var="begin" value="1" scope="page"></c:set>
                    <c:set var="end" value="5" scope="page"></c:set>
                </c:if>
                <!-- 当前页码大于3 -->
                <c:if test="${page.pageNo > 3}">
                    <c:set var="begin" value="${page.pageNo-2}" scope="page"></c:set>
                    <c:set var="end" value="${page.pageNo+2}" scope="page"></c:set>
                </c:if>
                <!-- 当前页码+2大于总页码 end就到总页码结束 begin:总页码-4 -->
                <c:if test="${page.pageNo+2 >= page.totalPage}">
                    <c:set var="begin" value="${page.totalPage-4}" scope="page"></c:set>
                    <c:set var="end" value="${page.totalPage}" scope="page"></c:set>
                </c:if>
            </c:if>


            <!-- 显示所有页码 -->
            <c:forEach begin="${begin}" end="${end}" var="pnum">
                <!-- 判断当前遍历的页码号是否为当前页码，是的话就不加链接 -->
                <c:if test="${pnum == page.pageNo}">
                    【${page.pageNo}】
                </c:if>
                <!-- 不是当前页码，则加超链接 -->
                <c:if test="${pnum != page.pageNo}">
                    <a href="manager/BookManagerServlet?method=page&pn=${pnum}">${pnum}</a>
                </c:if>
            </c:forEach>
            
            <c:if test="${page.hasNext}">
                <a href="manager/BookManagerServlet?method=page&pn=${page.pageNo+1}">下一页</a>
            </c:if>
            <a href="manager/BookManagerServlet?method=page&pn=${page.totalPage}">末页</a>
            共${page.totalPage}页，${page.totalCount}条记录到<input value="${page.pageNo}" name="pn" id="pn_input" />页
            <input type="button" value="确定" id="gotopage">
        </div>
    </body>
</html>
