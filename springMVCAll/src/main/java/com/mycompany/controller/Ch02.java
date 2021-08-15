/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * RequestMapping:
 *  value: 所有请求地址的公共部分，叫做模块名称
 *  位置：放在类上面
 * e.g.:http://localhost:8080/requestMapping/user/some.do
 * e.g.:http://localhost:8080/requestMapping/user/other.do
 * @author bwu
 */
@Controller
@RequestMapping("/ch02")
public class Ch02 {
    
  
    /**
     * 
     * RequestMapping: 请求映射
     *          属性：method 表示请求的方式。它的值是requestmethod的类枚举值，例如get是RequestMethod.GET, post是RequestMethod.POST
     * 
     * 
     * @return 
     */
    //@RequestMapping(value = {"/test/some.do" , "/test/first.do"})
    @RequestMapping(value = "/some", method = RequestMethod.GET)
    public ModelAndView doSome(){
      
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("msg", "welcome to use springmvc");
        mv.addObject("fun", "do some method");
       
        mv.setViewName("ch02/show");
        
        return mv;
    }
    
    
    //@RequestMapping(value = {"/test/other.do", "/test/second.do"})
    @RequestMapping(value = "/other", method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "@@@@@@@@welcome to use springmvc");
        mv.addObject("fun", "do other method");
        mv.setViewName("ch02/other");
        
        return mv;
    }
    
    //不指定请求方式，没有限制
    @RequestMapping(value = "/first.do")
    public ModelAndView doFrist(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "@@@@@@@@welcome to use springmvc - name is:" + request.getParameter("name"));
        mv.addObject("fun", "do first method");
        mv.setViewName("ch02/other");
        
        return mv;
    }
}
