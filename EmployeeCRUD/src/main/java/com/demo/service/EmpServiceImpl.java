package com.demo.service;

import java.util.List;

import com.demo.dao.EmpDao;
import com.demo.dao.EmpDaoImpl;
import com.demo.model.Employee;

public class EmpServiceImpl implements EmpService {
	
	private EmpDao edao;
	
	public EmpServiceImpl() {
		edao=new EmpDaoImpl();
	}

	@Override
	public List<Employee> displayAllEmp() {
	
		return edao.displayAllEmp();
	
	}

	@Override
	public void insertEmployee(Employee e) {
		edao.insertEmployee(e);
		
	}

	@Override
	public Employee getById(int id) {
	
		return edao.getById(id);
	}

	@Override
	public void updateemp(Employee e) {
		edao.updateemp(e);
		
	}

	@Override
	public void deleteemp(int id) {
		edao.deleteemp(id);
	}

}
