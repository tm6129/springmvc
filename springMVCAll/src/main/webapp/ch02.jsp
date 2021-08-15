<%-- 
    Document   : index
    Created on : Mar 15, 2021, 10:25:51 PM
    Author     : bwu
--%>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <p>02-request mapping (send request to controller with Get / Post method)</p>
        <p><a href="ch02/some">发起some的get请求 - All good</a></p>
        
        <p><a href="ch02/other">发起other的post请求 - wrong 405 error</a>
        因为backend method set method = RequestMethod.POST, 若在前端用get请求方式，会有405错误， 下面就可以
        </p>
        
        <br/>
        <form action="ch02/other" method="post">
            
            <p>因为backend method set method = RequestMethod.POST, 若在前端用post请求方式，All good</p>
            <input type="submit" value="post other">
        </form>
        <br/>
        <br/>
        
        
        <p>backend doesnt have method = RequestMethod.POST or method = RequestMethod.GET in @RequestMapping, 
            下面两种方式都okay
        </p>
        <p><a href="ch02/first.do">发起fisrt.do的get请求 - All good</a></p>
        <form action="ch02/first.do" method="post">
            <input type="submit" value="post fisrt">
        </form>
        
        
    </body>
</html>
