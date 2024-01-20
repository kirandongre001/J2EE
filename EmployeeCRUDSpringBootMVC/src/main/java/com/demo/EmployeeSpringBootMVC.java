package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mypackage.controller"})
public class EmployeeSpringBootMVC {
	public static void main(String[] args) {
		//it returns ApplicationContext
		SpringApplication.run(EmployeeSpringBootMVC.class,args);
	}

}
