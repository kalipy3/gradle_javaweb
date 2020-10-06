<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="250.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <jsp:forward page="250.jsp">
            <jsp:param value="hanser" name="username" />
            <jsp:param value="yousa" name="password" />
        </jsp:forward>
    </body>
</html>
