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
public class Student {
    
    private String name;
    private Integer age;

    public Student() {
        System.out.println("无参构造方法");
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName name:" + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge age:" + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + '}';
    }
    
    
    
    
}
