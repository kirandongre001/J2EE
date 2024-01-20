package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AdminDao;
import com.demo.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao ad;

	@Override
	public Admin validate(String aname, String password) {
		// TODO Auto-generated method stub
		return ad.validate(aname,password);
	} 
	
}
