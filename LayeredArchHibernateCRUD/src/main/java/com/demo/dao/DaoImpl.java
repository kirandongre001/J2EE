package com.demo.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.model.MyUser;

public class DaoImpl implements DaoInterface {

	static SessionFactory sf;
	static {
		sf=HibernateUtil.getMySessionFactory();
	}

	public void insertUser(MyUser u) {
		Session ses=sf.openSession();
		Transaction tf=ses.beginTransaction();
		ses.save(u);
		tf.commit();
		ses.close();
		
	}

	public List<MyUser> getAllUser() {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("from MyUser");
		
		List<MyUser> lu= q.list();
		
		t.commit();
		s.close();
		
		return lu;
		
	}

	@Override
	public MyUser getById(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser obj=session.get(MyUser.class,id );
		tr.commit();
		session.close();
		return obj;
	}

	@Override
	public boolean delete(int i) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser u=session.get(MyUser.class,i);
		session.delete(u);
		tr.commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(int id, String n, int i, String s, String c) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser u=session.get(MyUser.class,id);
		if(u!=null) {
			u.setUname(n);
			u.getAddr().setAddrid(i);
			u.getAddr().setStreet(s);
			u.getAddr().setCity(c);
			session.update(u);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		
		return true;
	}
	@Override
	public List<MyUser> sortById() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from MyUser u order by u.uid desc");
		List<MyUser> ulist=query.list();
		tr.commit();
		session.close();
		return ulist;
	}
	@Override
	public void closeMyServiceFactory() {
		HibernateUtil.closeMyFactory();
		
	}

}

