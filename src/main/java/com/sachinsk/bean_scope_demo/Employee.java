package com.sachinsk.bean_scope_demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    public Employee() {
        System.out.println("Employee.java -> Employee bean is created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Employee.java -> Employee Object Id : " + this.hashCode());
    }
}
