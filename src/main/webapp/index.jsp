<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <!-- jsp脚本片段 pageContext,request,session,application 在资源之间共享数据 -->
        <%
        pageContext.setAttribute("pageAttr", "pageValue");
        request.setAttribute("requestAttr", "requestValue");
        session.setAttribute("sessionAttr", "sessionValue");
        application.setAttribute("appAttr", "appValue");
        %>

        <hr/>
        jsp表达式方式取出四个域中的内容：<br/>
        page:<%=pageContext.getAttribute("pageAttr") %><br/>
        request:<%=request.getAttribute("requestAttr") %><br/>
        session:<%=session.getAttribute("sessionAttr") %><br/>
        application:<%=application.getAttribute("appAttr") %><br/>
        <hr/>
        <%-- ${表达式内容} --%>
        使用el表达式获取域内容<br/>
        page:${pageAttr}<br/>
        request:${requestAttr}<br/>
        session:${sessionAttr}<br/>
        application:${appAttr}<br/>
    </body>
</html>
