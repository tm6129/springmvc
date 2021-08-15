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
        <p>03-receive param (send request with Params) 提交参数给controller</p>
        <br/><br/>
        <p>当input有中文，Submit form时，如不设置filter 会有乱码。(send request to backend)<br/>
            解决方法就是在web.xml中设置
            <filter>
            <filter-name>characterEncodingFilter</filter-name>
        </p>
        <br/><br/>
        
        <br/>
        <span>前端form里面的input name 分别是name和age<br/>
            后端接受:
            public ModelAndView doSome(String name, int age){
        </span>
        <form action="${pageContext.request.contextPath}/ch03/receiveproperty" method="post">
            name: <input type="text" name="name"><br/>
            age: <input type="text" name="age"><br/>
            <input type="submit" value="Submit Form">
        </form>
        
        <br/>
        <span>前端form里面的input name 分别是rname和rage <br/>
             后端接受:
             public ModelAndView doParam(@RequestParam(value = "rname", required = false) String name, 
                                @RequestParam(value = "rage", required = false) String age){
        </span>
        <p>请求参数名和处理器方法的形参名不一样</p>
        <form action="${pageContext.request.contextPath}/ch03/receiveparam" method="post">
            name: <input type="text" name="rname"><br/>
            age: <input type="text" name="rage"><br/>
            <input type="submit" value="Submit Form">
        </form>
        
        
        <br/>
        <p>使用java对象接受请求参数</p>
         <span>前端form里面的input name 分别是name和age<br/>
            后端接受:
            public ModelAndView doObject(Student mystudent, School school){
            mystudent 里面又相对应的name和age
        </span>
        <form action="${pageContext.request.contextPath}/ch03/receiveobject" method="post">
            name: <input type="text" name="name"><br/>
            age: <input type="text" name="age"><br/>
            <input type="submit" value="Submit Form">
        </form>
        
    </body>
</html>
