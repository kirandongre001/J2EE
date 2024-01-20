package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao edao;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return edao.getAllEmployee();
	}

	@Override
	public void insertemp(Employee e) {
		edao.insert(e);
		
	}

	@Override
	public Employee getById(int empid) {
		// TODO Auto-generated method stub
		return edao.getByid(empid);
	}

	@Override
	public void updateemp(Employee e) {
	  edao.update(e);
		
	}

	@Override
	public void deleteById(int empid) {
		// TODO Auto-generated method stub
		edao.deleteById(empid);
	}

}
