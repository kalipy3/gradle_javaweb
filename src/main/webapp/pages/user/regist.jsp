<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <%@include file="/include/base.jsp" %>
        <script type="text/javascript">
             $(function() {
                  //点击图片更换验证码
                  $("#codeImg").click(function(){
                     //改变src,为了让浏览器知道这是新请求，不然注册失败后再点验证码，有的浏览器会直接从缓存里面拿验证码图片
                     var url = "code.jpg?t="+Math.random();
                     $(this).prop("src", url);
                  })
             })
        </script>
    </head>
    <body>
        <h1>注册页面</h1>

        <span class="errorMsg">
            <%-- <%=request.getAttribute("msg")==null?"请输入用户名":request.getAttribute("msg") %> --%>
            ${msg==null?"请输入用户名":msg}
        </span>

        <form action="UserServlet" method="get">
            <input type="hidden" name="method" value="regist">
            <label>用户名：</label>
            <input type="text" name="username" placeholder="请输入用户名" value="${param.username}" />
            <label>密码：</label>
            <input type="password" placeholder="请输入密码" name="password" />
            <label>邮箱：</label>
            <input type="text" placeholder="请输入邮箱" name="email" value="${param.email}"/>
            <br/>
            <br/>
            <label>验证码：</label>
            <input type="text" name="code" style="width: 150px;"/>
            <img src="code.jpg" alt="" style="float: right; margin-right: 40px; width: 120px; height: 50px;" id="codeImg">
            <br/>
            <br/>
            <input type="submit" value="注册">
        </form>
    </body>
</html>
