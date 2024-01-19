package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeDao edao;

}
