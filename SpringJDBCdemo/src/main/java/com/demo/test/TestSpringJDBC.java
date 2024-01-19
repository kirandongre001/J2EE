package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Product;
import com.demo.service.ProductService;

public class TestSpringJDBC {

	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("springconfig.xml");
		
		ProductService ps=(ProductService)c.getBean("productServiceImpl");
		
		Scanner sc=new Scanner(System.in);
		
		int ch=0;
		
		do {
			System.out.println("Menu Driven:");
			System.out.println("1.Add New Product\n2.Display All Product\n3.Display By Id\n4.Delete Product\n5.Modify The Product\n6.Display by Quantity\n7.Exit\n");
			System.out.println("Enter the Choice");
			
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				int n=ps.addProduct();
				if(n>0) {
					System.out.println("Product got added");
				}
				break;
			case 2:
				List<Product> lp=ps.displayAllProduct();
				lp.forEach(System.out::println);
				break;
			case 3:
				System.out.println("Enter the id to display Product");
				int id=sc.nextInt();
				Product p=ps.displayById(id);
				System.out.println(p);
				break;
			case 4:
				System.out.println("Enter the id to Delete Product");
				id=sc.nextInt();
			    int n1=ps.deleteById(id);
				if(n1>0) {
					System.out.println("Product got deleted");
				}

				break;
			case 5:
				int n2=ps.modifyProduct();
				if(n2>0) {
					System.out.println("Product got modified");
				}
				break;
			case 6:
				System.out.println("Enter the id to display Product");
				int qty=sc.nextInt();
				Product p1=ps.displayByQty(qty);
				System.out.println(p1);

				break;
			case 7:
				break;
			}
			
		}while(ch!=7);

	}

}
