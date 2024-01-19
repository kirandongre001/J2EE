package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.MyUser;
//import com.demo.model.Student;

public class TestBeanWiring {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyUser u1=(MyUser) ctx.getBean("u1");
		System.out.println(u1);
//		Student s=(Student)ctx.getBean("st1");
//		System.out.println(s);
		
		
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
