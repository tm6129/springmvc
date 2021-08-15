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
        <script type="text/javascript" src='js/jquery-1.11.1.min.js'></script>
    </head>
    <body>
        <p>
            解决静态资源的冲突<br/>
            1. web.xml 的url pattern是“/”<br/>
            2. 在springmvc中需要配置< mvc:resources mapping="/static/**" location="/static/" /> 和加入< mvc:annotation-driven />
            
        </p>
        <br/>
        <form action="ch05/some" method="post">
            name: <input type="text" name="name"><br/>
            age: <input type="text" name="age"><br/>
            <input type="submit" value="Submit Form">
        </form>
        <br/>
        
        <img src="static/images/stash2.png" alt="静态资源，不能显示">
        
       
    </body>
</html>
