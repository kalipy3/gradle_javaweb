<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@ page language="java" import="com.test.Student" %>
<%@ page language="java" import="java.util.*" %>

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
              空数组 int[] i = null;
              空字符串
              空字符
        -->
        <%
        Student stu = null;
        List<Student> list = new ArrayList<Student>();
        int[] i = null;
        Map<String, Object> map = new HashMap<String, Object>();
        //list.add(null);
        pageContext.setAttribute("list", i);
        System.out.println(i.length);//0
        %>
        ${empty pageScope.list}<br/>
    </body>
</html>
