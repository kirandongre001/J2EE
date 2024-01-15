package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class TestMyUserAddress {
public static void main(String[] args) {
	Address ad=new Address(1,"model","pune");
	Address ad1=new Address(2,"gym khana","pune");
	MyUser u= new MyUser(1,"kiran",ad1);
	MyUser u1=new MyUser(2,"tushar",ad);
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session ses=sf.openSession();
	Transaction tf=ses.beginTransaction();
	ses.save(u);
	ses.save(u1);
	
    MyUser uo=ses.get(MyUser.class, 1);
	System.out.println(uo);
	tf.commit();
	ses.close();
}
}
