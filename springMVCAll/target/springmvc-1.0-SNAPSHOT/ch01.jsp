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
        <p>First mvc project</p>
        
        <p><a href="${pageContext.request.contextPath}/ch01/some">发起some的请求</a></p>
        <p><a href="${pageContext.request.contextPath}/ch01/other">发起other的请求</a></p>
    </body>
</html>
