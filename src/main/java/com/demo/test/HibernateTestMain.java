package com.demo.test;
import java.util.*;

import com.demo.model.MyUser;
import com.demo.service.*;

public class HibernateTestMain {
 public static void main(String[] args) {
	int ch=0;
	Scanner sc=new Scanner (System.in);
	
	ServiceInterface si=new ServiceImpl();
	do {	
	System.out.println("Enter choice");
	System.out.println("1.Add User\n2.Show users\n3.Show User by Id\n4.Delete User by Id\n5.Update User by Id\n6.Sort by Id\n7.Exit\n");
	System.out.println("Enter choice:");
	
	ch=sc.nextInt();
	
	switch(ch) {
	case 1:
		si.addUser();
		break;
	case 2:
		List<MyUser> lu=si.getAllUser();
		lu.forEach(System.out::println);
		break;
	case 3:
		System.out.println("Enter UserId to display User");
		int i=sc.nextInt();
		MyUser u=si.getById(i);
		System.out.println(u);
		break;
	case 4:
		System.out.println("Enter UserId to delete");
		i=sc.nextInt();
		boolean b=si.deleteById(i);
		if(b)
		System.out.println("Deleted");
		break;
	case 5:
	    b=si.updateUser();
	    if(b) {
	    	System.out.println("Updated!!!");
	    }
		break;
	case 6:
		List<MyUser> list=si.sortUser();
		list.forEach(System.out::println);
		break;
	case 7:
		break;
	}
	}while(ch!=7);
}
}
