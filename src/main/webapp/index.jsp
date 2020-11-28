<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@ page language="java" import="com.test.Student" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <!-- jsp脚本片段 pageContext,request,session,application 在资源之间共享数据 -->
        <%
        Student stu = new Student(1, "张三", "password", "email", 18);
        pageContext.setAttribute("stu", stu);
        request.setAttribute("stu-x", stu);
        session.setAttribute("stu", "sessionValue");
        application.setAttribute("stu", "appValue");
        String str = "你好";
        %>

        <hr/>
        jsp表达式：<%=request.getAttribute("stu-x") %><br/>
        el表达式：${requestScope['stu-x']['username']}<br/>
        <hr/>
        <%-- ${表达式内容} --%>
        使用el表达式获取域内容<br/>
        page:${pageScope.stu.username}<br/>
        request:${requestScope.stu}<br/>
        session:${sessionScope.stu}<br/>
        application:${applicationScope.stu}<br/>


        <hr/>
        <!-- el中的其它对象 pageContext可以取出jsp页面其它的隐含对象，接下来就可以取出所有隐含对象中的属性了 -->
        ${pageContext.request.scheme}<br/>
        <%=pageContext.getRequest().getScheme() %><br/>

        <!-- 和http协议有关 5个 -->
        param (封装了所有的请求参数的key-value) 对应一个请求参数 request.getParameter("username")<br/>
        paramValues 对应一组请求参数<br/>
        header 请求头 request.getHeader("User-Agent")<br/>
        headerValues 请求头返回字符数组<br/>
        cookie 获取某个cookie对象 取出cookie的值<br/>

        <!-- 请这样访问index.jsp 127.0.0.1:8080/01Servlet/index.jsp?username=kalipy -->
        获取请求参数:${param.username}<br/>
        <!-- 请这样访问index.jsp 127.0.0.1:8080/01Servlet/index.jsp?username=kalipy&ah=hanser&ah=yousa&ah=merry -->
        获取请求参数2:${paramValues.ah[0]},${paramValues.ah[1]},${paramValues.ah[2]}<br/>
        获取请求头1:${header['User-Agent']}<br/>
        获取请求头2:${header['Host']}<br/>
        <!-- cookie是一个对象 -->
        获取Cookie:${cookie.JSESSIONID.name} || ${cookie.JSESSIONID.value}<br/>
        <!-- 获取web的初始化参数 -->
        获取初始化参数:${initParam.user}
    </body>
</html>
