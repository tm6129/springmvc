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
        
        <base href="<%=basePath%>"></base>
    </head>
    <body>
        <p><a href="ch06/first.do">发起fisrt.do的get请求("ch06/first.do") - okay</a></p>
        
        
        <p><a href="/ch06/first.do">发起fisrt.do的get请求("/ch06/first.do") - not okay</a></p>
        
        <p><a href="${pageContext.request.contextPath}/ch06/first.do">发起fisrt.do的get请求("${pageContext.request.contextPath}/ch06/first.do") - okay</a></p>
        
        <p><a href="ch06/some.do">发起fisrt.do的get请求("ch06/some.do") 去掉在springmvc.xml中的地址解析器才测试</a><br/>
            not okay - 页面的url会变成http://localhost:8080/springmvcAll/ch06/some.do 但显示index.jsp的内容
                <br/>如果此时再点这链接，url就会变为http://localhost:8080/springmvcAll/ch06/ch06.jsp</p>
    </body>
</html>
