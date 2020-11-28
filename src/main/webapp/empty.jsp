<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@ page language="java" import="com.test.Student" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <!--el表达式中的empty运算符 就是判断一个对象是否为空 
              null
              1.变量的值是null
              2.域对象中不存在这个变量
              空集合
              空数组
              空字符串
              空字符
        -->
        <%
        Student stu = new Student(1, "username", "password", "email", 18);
        Student stu2 = new Student();
        Student stu3 = null;
        pageContext.setAttribute("stu", stu);
        pageContext.setAttribute("stu2", stu2);
        pageContext.setAttribute("stu3", stu3);
        %>
        ${empty pageScope.stu}<br/>
        ${empty pageScope.stu2}<br/>
        ${empty pageScope.stu3}<br/>
        ${empty pageScope.stux}<br/>
    </body>
</html>
