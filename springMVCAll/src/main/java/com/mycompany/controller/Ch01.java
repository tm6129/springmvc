/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @Controller: 创建处理器对象，对象放在springmvc容器中
 * 位置：在类的上面
 * 和spring中讲的@service， @component
 * 
 * 
 * @author bwu
 */
@Controller
@RequestMapping("/ch01")
public class Ch01 {
    
    /*
    处理用户提交的请求，springmvc中使用方法来处理的
    方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
    
    */
    
    
    /**
     * 
     * 准备使用dosome方法来处理some.do请求
     * @RequestMapping: 请求映射，作用是把一个请求地址和一个方法绑定在一起。
     *                   一个请求指定一个方法处理
     *      属性：1. value - string 表示请求的uri地址(some.do)
     *              value是唯一的，不能重复。在使用是，推荐使用以“/”为开头
     *      位置： 1. 在方法的上面，常用的
     *          2. 在类的上面
     * 说明：使用@RequestMapping修饰的方法叫做处理器方法和控制器方法
     * 使用@RequestMapping修饰的方法可以处理请求，类似servlet中的doGet,doPost
     * 
     * 返回值：ModelAndView 表示本次请求的处理结果
     * Model:数据，请求处理完成后，显示给用户的数据
     * View:视图，比如jsp等等
    */
    
    @RequestMapping(value = {"some", "/some.do" , "/first.do"})
    public ModelAndView doSome(){
        //处理some.do请求 - 相当于service条用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后数据放入到request作用域
        //request.setAttribute("msg", "welcome to use springmvc");
        mv.addObject("msg", "welcome to use springmvc");
        mv.addObject("fun", "do some method");
        
        //指定视图,指定视图的完整数据
        //框架对视图执行的forward操作，request.getRequestDispatch("/show.jsp").forward(...)
        
        //mv.setViewName("/WEB-INF/view/show.jsp");
        //当配置了视图解析器后（<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">），可以使用逻辑名称（文件名）来指定视图
        //框架会使用视图解析器的前缀 + 逻辑名称 + 后缀 组成完整路径，这里就是字符串链接操作
        
        mv.setViewName("ch01/show");
        
        
        return mv;
    }
    
    
    @RequestMapping(value = {"other", "/other.do", "/second.do"})
    public ModelAndView doOther(){
        
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("msg", "@@@@@@@@welcome to use springmvc");
        mv.addObject("fun", "do other method");
        mv.setViewName("ch01/other");
        
        return mv;
    }
}
