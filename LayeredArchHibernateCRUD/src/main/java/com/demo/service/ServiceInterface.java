package com.demo.service;

import java.util.List;

import com.demo.model.MyUser;

public interface ServiceInterface {

	void addUser();

	List<MyUser> getAllUser();

	MyUser getById(int i);

	boolean deleteById(int i);

	boolean updateUser();

	List<MyUser> sortUser();

}
