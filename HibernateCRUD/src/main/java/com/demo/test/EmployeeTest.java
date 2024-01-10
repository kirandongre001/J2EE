package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee emp=new Employee(1,"Kiran", 3456);
		Employee emp1=new Employee(2,"tushar",6543);

		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();

		session.save(emp);	
		session.save(emp1);
		
		session.get(Employee.class,2);
		System.out.println("Tushar data:");
		System.out.println(emp1);
		
		session.load(Employee.class,1);
		System.out.println("Kiran Data");
		System.out.println(emp.getName());
		
		tr.commit();
		session.close();
		
		emp1.setName("lucky");//deattached
		Session ses1=sf.openSession();
		Transaction tr1=ses1.beginTransaction();
		
		
		//Employee e1=ses1.get(Employee.class,2);
		
		ses1.update(emp1);
		//ses1.saveOrUpdate(emp1);
		//ses1.merge(emp1);
		ses1.get(Employee.class, 2);
		System.out.println(emp1);
		
		tr1.commit();
		ses1.close();	
		
	}
}
