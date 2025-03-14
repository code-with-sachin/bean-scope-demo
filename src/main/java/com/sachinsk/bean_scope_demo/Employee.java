package com.sachinsk.bean_scope_demo;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
//@Scope("prototype")
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope("session")
public class Employee {
    public Employee() {
        System.out.println("Employee.java -> Employee bean is created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Employee.java -> Employee Object Id : " + this.hashCode());
    }
}
