package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	void insertemp(Employee e);

	Employee getById(int empid);

	void updateemp(Employee e);

	void deleteById(int empid);


}
