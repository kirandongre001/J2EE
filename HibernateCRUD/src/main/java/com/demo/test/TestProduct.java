package com.demo.test;
import com.demo.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestProduct {
	
	public static void main(String[] args) {
		
		
		Product pobj=new Product("dairy-Milk",123,2);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();
		
		session.save(pobj);
		
		tr.commit();
		session.close();
	}

}
