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
        <script type="text/javascript" src='js/jquery-1.11.1.min.js'></script>
        <script type="text/javascript">
            $(function (){
                $("#btn").click(function(){
                    //alert("aa");
                    $.ajax({
                        url:"ch04/returnvoid-ajax.do",
                        data:{
                            name:"zhangsan",
                            age:"44"
                        },
                        type:"post",
                        dataType:"json",//表示想要json数据
                        //可以不写，应为后端已经有response.setContentType("application/json；charset=utf-8");//告诉浏览器是json数据
                        success:function(resp){
                            alert(resp);
                            console.log(resp.name + "," + resp.age);
                        }
                    });
                });


                $("#btn2").click(function(){
                    //alert("aa");
                    $.ajax({
                        url:"ch04/returnStudentJson.do",
                        data:{
                            name:"zhangsan",
                            age:"44"
                        },
                        type:"post",
                        dataType:"json",//表示想要json数据
                        //可以不写，应为后端已经有response.setContentType("application/json；charset=utf-8");//告诉浏览器是json数据
                        success:function(resp){
                            alert(resp);
                            console.log("returnStudentJson.do:" + resp.name + "," + resp.age);
                        }
                    });
                });


                $("#btn3").click(function(){
                    //alert("aa");
                    $.ajax({
                        url:"ch04/returnStudentJsonArray.do",
                        data:{
                            name:"zhangsan",
                            age:"44"
                        },
                        type:"post",
                        dataType:"json",//表示想要json数据
                        //可以不写，应为后端已经有response.setContentType("application/json；charset=utf-8");//告诉浏览器是json数据
                        success:function(resp){
                            alert(resp);
                            $.each(resp, function(i, n){
                               console.log(n.name + " " + n.age); 
                            });


                            //console.log("returnStudentJson.do:" + resp.name + "," + resp.age);
                        }
                    });
                });


                $("#btn4").click(function(){
                    //alert("aa");
                    $.ajax({
                        url:"ch04/returnString-data.do",
                        data:{
                            name:"zhangsan",
                            age:"44"
                        },
                        type:"post",
                        //dataType:"json", //当return是string 就不需要datatype 或者用datatype:"text"
                        //可以不写，应为后端已经有response.setContentType("application/json；charset=utf-8");//告诉浏览器是json数据
                        success:function(resp){
                            alert("returnString-data.do:" + resp);
                        }
                    });
                });
            });

        </script>  
    </head>
    <body>
        <p>控制器方法返回String表示视图名称</p>
        <br/>
        <form action="ch04/returnString-view.do" method="post">
            name: <input type="text" name="name"><br/>
            age: <input type="text" name="age"><br/>
            <input type="submit" value="Submit Form">
        </form>
        
        <br/>
        <p>控制器方法返回String表示完整路径</p>
        <form action="ch04/returnString-view2.do" method="post">
            name: <input type="text" name="name"><br/>
            age: <input type="text" name="age"><br/>
            <input type="submit" value="Submit Form">
        </form>
        
        <br/>
        <button id="btn">ajax request for void</button>
        
        <br/>
        <button id="btn2">ajax request for return student</button>
        
        <br/>
        <button id="btn3">ajax request for return student Array</button>
        
        <br/>
        <button id="btn4">ajax request for return Striing as data</button>
        <p>
            当return String 有中文 会导致输出有乱码，是因为默认response header的contenttype是text/plain;charset=ISO-8859-1。
            * 解决方案，给requestmapping增加一个produces，可以使用这个属性指定新的contentType
        </p>
        
       
    </body>
    
    
       
</html>
