<%-- 
    Document   : index
    Created on : Mar 15, 2021, 10:25:51 PM
    Author     : bwu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="ch01.jsp">01-first spring</a></p>
        <p><a href="ch01/show.jsp">To access "ch01/show.jsp" will have 404 ("ch01/show.jsp" is inside WEB-INF)</a></p>
        <p><a href="ch02.jsp">02-request mapping (send request to controller with Get / Post method)</a></p>
        <p><a href="ch03.jsp">03-receive param (send request with Params)</a></p>
        <p><a href="ch04.jsp">04-return (返回modelandview, 返回String视图，返回ajax响应（@ResponseBody），返回string数据类型（@ResponseBody） )</a></p>
        <p><a href="ch05.jsp">05-url pattern (静态资源的配置)</a></p>
        <p><a href="ch06.jsp">06-path (加入“/”与不加入“/”的区别)</a></p>
    </body>
</html>
