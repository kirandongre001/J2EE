package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmpService {
	
	List<Employee>displayAllEmp();

	void insertEmployee(Employee e);

	Employee getById(int id);

	void updateemp(Employee e);

	void deleteemp(int id);
	
	
	
}
