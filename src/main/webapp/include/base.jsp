<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!-- 所有页面要引入的资源
base标签的链接需要动态获取，而不是指定
http://localhost:8080/01Servlet/
协议://主机名:端口号/项目路径/
-->
<base href="<%=request.getScheme() %>://<%=request.getServerName() %>:<%=request.getServerPort() %><%=request.getContextPath() %>/" />