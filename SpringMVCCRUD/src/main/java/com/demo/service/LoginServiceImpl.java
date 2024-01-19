package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDao;
import com.demo.model.MyUser;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao ddao;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside Login Service Impl");
	}

	@Override
	public MyUser validate(String uname, String password) {
		// TODO Auto-generated method stub
		return ddao.validate(uname,password);
	}
	
}
