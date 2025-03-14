package com.sachinsk.bean_scope_demo;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("singleton")
//@Scope("prototype")
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeController {

    @Autowired
    private Employee employee;

    public EmployeeController() {
        System.out.println("EmployeeController.java -> EmployeeController bean is created");
    }

    @PostConstruct
    public void init() {
        System.out.println("EmployeeController.java -> EmployeeController Object Id : " + this.hashCode());
        System.out.println("EmployeeController.java -> Employee Object Id : " + employee.hashCode());
    }

    @GetMapping("/info")
    public String printInfo() {
        System.out.println("EmployeeController.java /info -> EmployeeController Object Id : " + this.hashCode());
        System.out.println("EmployeeController.java /info -> Employee Object Id : " + employee.hashCode());
        return "Info OK";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        System.out.println("EmployeeController.java /logout -> EmployeeController Object Id : " + this.hashCode());
        System.out.println("EmployeeController.java /logout -> Employee Object Id : " + employee.hashCode());
        request.getSession().invalidate();
        return "Session closed";
    }

}
