package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployee();

	void insert(Employee e);

	Employee getByid(int empid);

	void update(Employee e);

	void deleteById(int empid);

}
