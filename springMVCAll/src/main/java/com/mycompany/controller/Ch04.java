/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.vo.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author bwu
 */
@Controller
@RequestMapping("/ch04")
public class Ch04 {
    
    /**
     * 控制器方法返回String - 表示视图名称，需要配置视图解析器（springmvc.xml） - org.springframework.web.servlet.view.InternalResourceViewResolver
     * name和age依然是逐个参数接受
     * 
     * @return 
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, int age){
        
        //可以手痛添加数据到request作用域
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        
        //show: 逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行了forward转发操作
        return "ch04/show";
    }
    
    
    //控制器方法返回string，表示完整视图路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request, String name, int age){
        //可以手痛添加数据到request作用域
        
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        
       //要返回完整路径，所以项目中springmvc.xml不能配置视图解析器
        return "/WEB-INF/view/ch04/show.jsp";
    }
    
    
    
    @RequestMapping(value = "/returnvoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, int age) throws JsonProcessingException, IOException{
        //可以手痛添加数据到request作用域
        System.out.println("doReturnVoidAjax name:" + name + ", age:" + age); 
        
        Student s = new Student();
        s.setName(name);
        s.setAge(age);
        
        String json = "";
        if(s != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(s);
            System.out.println("json:" + json);
        }
        
        response.setContentType("application/json；charset=utf-8");//告诉浏览器是json数据
        PrintWriter pw = response.getWriter();
        pw.write(json);
        pw.flush();
        pw.close();
        
        
    }
    
    
    
    /**
     * 
     * 控制器方法返回一个student对象，响应ajax请求
     * 
     * @ResponseBody 
     *      作用：把返回的对象转为json后，通过HttpServletResponse输出给浏览器。
     *      位置：方法定义的上面，和其他注解没有顺序的关系
     * 框架的处理流程
     * 1. 框架会把Student类型，调用框架中的Arraylist<HttpMessageConvert>中每个类的canwrite（）方法，检查那个HttpMessageConvter接口的实现类能处理student类型的数据-也就是MappingJackson2HttpMessageConverter
     * 
     * 2. 框架会调用实现类的write（），也就是MappingJackson2HttpMessageConverter的write（）方法，把student对象转为json，调用jackson的objectmapper实现为json
     * 
     * 3. 框架会调用responsebody把2的结果数据输出浏览器。完成ajax请求
     *  
     * 
     * 
     * @param response
     * @param name
     * @param age
     * @throws JsonProcessingException
     * @throws IOException 
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, int age) throws JsonProcessingException, IOException{
        System.out.println("doStudentJsonObject name:" + name + ", age:" + age); 
        
        Student s = new Student();
        s.setName("haha");
        s.setAge(24);
        
        return s;
        
        
    }
    
    
    /**
     * 
     * 控制器放回List<Student>
     * 
     * @param name
     * @param age
     * @return
     * @throws JsonProcessingException
     * @throws IOException 
     */
    
    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, int age) throws JsonProcessingException, IOException{
        //可以手痛添加数据到request作用域
        System.out.println("doStudentJsonObjectArray name:" + name + ", age:" + age); 
        
        List<Student> list = new ArrayList<>();
        
        Student s = new Student();
        s.setName("hahha");
        s.setAge(28);
        list.add(s);
            
        s = new Student();
        s.setName("aaaa");
        s.setAge(24);
        list.add(s);
        
        
        return list;
        
        
    }
 
    
    
    /**
     * 
     * 
     * 控制器返回string，string是表示数据，不是视图。区别在于注解ResponseBody
     * 
     * return String 有乱码，是因为默认response header的contenttype是text/plain;charset=ISO-8859-1。
     * 解决方案，给requestmapping增加一个produces，可以使用这个属性指定新的contentType
     * 
     * @param request
     * @param name
     * @param age
     * @return 
     */
    @RequestMapping(value = "/returnString-data.do", produces="text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(HttpServletRequest request, String name, int age){
        //可以手痛添加数据到request作用域
       
        return "Hello return String data 哈哈哈";
    }
}
