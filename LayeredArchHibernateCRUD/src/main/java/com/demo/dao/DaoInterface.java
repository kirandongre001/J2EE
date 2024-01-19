package com.demo.dao;

import java.util.List;

import com.demo.model.MyUser;

public interface DaoInterface {

	 void insertUser(MyUser u);

	 List<MyUser> getAllUser();

	MyUser getById(int id);

	boolean delete(int i);

	boolean update(int id, String n, int i, String s, String c);
	
	List<MyUser> sortById();

	void closeMyServiceFactory();

}
