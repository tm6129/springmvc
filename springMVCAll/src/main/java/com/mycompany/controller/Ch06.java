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
@RequestMapping("ch06")
public class Ch06 {
    
    
    //不指定请求方式，没有限制
    @RequestMapping(value = "/first.do") // same as value = "/user/some.do"
    public ModelAndView doFrist(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "@@@@@@@@welcome to use springmvc - name is:" + request.getParameter("name"));
        mv.addObject("fun", "do first method");
        mv.setViewName("ch06/other");
        
        return mv;
    }
    
    
    @RequestMapping(value = "/some.do") // same as value = "/user/some.do"
    public String doSome(HttpServletRequest request, HttpServletResponse response, HttpSession session){
      
        return "/index.jsp";
    }
}
