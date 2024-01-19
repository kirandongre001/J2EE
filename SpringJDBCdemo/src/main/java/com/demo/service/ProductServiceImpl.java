package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public abstract class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pd;
	
	public int addProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr pid");
		int pid=sc.nextInt();
		System.out.println("enetr pname");
		String pname=sc.next();
		System.out.println("enetr qty");
		int qty=sc.nextInt();
		System.out.println("enetr price");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,qty,price);
		
		return pd.insertProduct(p);
		
	}

	public List<Product> displayAllProduct() {
		return pd.getAllProduct();
		
	}

	@Override
	public Product displayById(int id) {
		// TODO Auto-generated method stub
		return pd.getById(id);
	}

	@Override
	public int deleteById(int id) {
		
		return pd.removeById(id);
	}

	public int modifyProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr pid");
		int pid=sc.nextInt();
		System.out.println("enetr pname");
		String pname=sc.next();
		System.out.println("enetr qty");
		int qty=sc.nextInt();
		System.out.println("enetr price");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,qty,price);
		
		return pd.UpdateProduct(p);
	}
	
	public Product displayByQty(int qty) {
		return pd.getByQty(qty);
	}
}
