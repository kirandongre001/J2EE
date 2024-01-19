package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootWebService{
	public static void main(String[] args) {
		//it returns ApplicationContext
		SpringApplication.run(MySpringBootWebService.class,args);
	}

}
