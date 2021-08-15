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
 * @author bwu
 */
@Controller
@RequestMapping("/ch05")
public class Ch05 {
    
    /**
     * 
     * @param name
     * @param age
     * @return 
     */
    @RequestMapping(value = "/some")
    public ModelAndView doSome(String name, int age){
        
       ModelAndView mv = new ModelAndView();
       mv.addObject("myname", name);
       mv.addObject("myage", age);
       
       mv.setViewName("ch05/show");
   
        
       return mv;
    }
    
    
    
}
