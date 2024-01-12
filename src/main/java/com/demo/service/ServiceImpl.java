package com.demo.service;
import java.util.*;
import com.demo.model.*;

import com.demo.dao.DaoImpl;
import com.demo.dao.DaoInterface;

public class ServiceImpl implements ServiceInterface{
	private DaoInterface udao;
	
	public ServiceImpl() {
		udao=new DaoImpl();
	}
	Scanner sc=new Scanner(System.in);

	public void addUser() {
		System.out.println("Enter User Id");
		int id=sc.nextInt();
		System.out.println("Enter User Name");
		String n=sc.next();
		System.out.println("Enter Address Id");
		int i=sc.nextInt();
		System.out.println("Enter Street");
		String s=sc.next();
		System.out.println("Enter City");
		String c=sc.next();
  
		MyUser u=new MyUser(id,n,new Address(i,s,c));
		udao.insertUser(u);
		
	}

	public List<MyUser> getAllUser() {
		return udao.getAllUser();
		
	}

	@Override
	public MyUser getById(int id) {
		
		return udao.getById(id);
	}

	@Override
	public boolean deleteById(int i) {
		// TODO Auto-generated method stub
		return udao.delete(i);
	}

	@Override
	public boolean updateUser() {
		System.out.println("Enter User Id");
		int id=sc.nextInt();
		System.out.println("Enter User Name");
		String n=sc.next();
		System.out.println("Enter Address Id");
		int i=sc.nextInt();
		System.out.println("Enter Street");
		String s=sc.next();
		System.out.println("Enter City");
		String c=sc.next();
  
		return udao.update(id,n,i,s,c);
		
		
	}

	@Override
	public List<MyUser> sortUser() {
		return udao.sortById();
		
	}

}
