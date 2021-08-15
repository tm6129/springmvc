/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vo;

/**
 *
 * @author bwu
 */
public class School {
    
    private String name;

    public School() {
        System.out.println("无参构造方法");
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName name:" + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" + "name=" + name + '}';
    }

   
    
    
    
    
}
