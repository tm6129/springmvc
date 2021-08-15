/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.vo.School;
import com.mycompany.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author bwu
 */
@Controller
@RequestMapping("/ch03")
public class Ch03 {
    
    /**
     * 逐个接收请求参数
     *      要求：控制器方法的形参和请求中参数名必须一致
     *          同名的请求参数赋值给同名的形参
     * 
     * 
     * 框架接收请求参数步骤
     * 1.   用request对象接收请求参数
     *      String name = request.getParamater("name");
     *      String age = request.getParamater("age");
     * 2.   springmvc框架通过dispatchservlet调用mycontroller的dosome（）方法，调用方法时，按名称对应，把接受的参数赋值给形参dosome(name, Integer.valueof(age))
     *      框架会提供类型转换的功能，能把string转为int，long，float，double
     * 
     * 
     * 
     * 如果name是中文，用get可以正常显示，但用post不能会显示乱码，以前servlet的解决方法是
     * public void doGet(HttpServletRequest request){
     *  request.setCharacterEncoding("utf-8");
     * }
     * Spring框架可以用过滤器解决乱码问题 - web.xml <filter-name>characterEncodingFilter</filter-name>
     * 
     * 
     * @return 
     */
    @RequestMapping(value = "/receiveproperty")
    public ModelAndView doSome(String name, int age){
      
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("myname", name);
        mv.addObject("myage", age);
      
        mv.setViewName("ch03/show");
        
        return mv;
    }
    
    
    /**
     * 请求中参数名和处理器方法的形参不一样 rname/rage -> name/age
     *  @RequestParam: 逐个接受的这中方式 解决这个问题
     *      属性：1.value请求中的参数名称
     *          2. required is boolean type, 默认是true
     *      位置： 在处理器方法的形参定义的前面
     * 
     * @param name
     * @param age
     * @return 
     */
    @RequestMapping(value = "/receiveparam")
    public ModelAndView doParam(@RequestParam(value = "rname", required = false) String name, 
                                @RequestParam(value = "rage", required = false) String age){
      
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("myname", name);
        mv.addObject("myage", age);
      
        mv.setViewName("ch03/show");
        
        return mv;
    }
    
    
    /**
     * 处理方法形参是java对象，这个对象的属性名和请求中参数名一样
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会用setname
     * 
     * 
     * @return 
     */
    @RequestMapping(value = "/receiveobject")
    public ModelAndView doObject(Student mystudent, School school){
      
        ModelAndView mv = new ModelAndView();
        
        
        
        mv.addObject("myname", mystudent.getName());
        mv.addObject("myage", mystudent.getAge());
        mv.addObject("mystudent", mystudent);
        
         mv.addObject("myschool", school);
       
        
      
        mv.setViewName("ch03/show");
        
        return mv;
    }
    
    
   
}
