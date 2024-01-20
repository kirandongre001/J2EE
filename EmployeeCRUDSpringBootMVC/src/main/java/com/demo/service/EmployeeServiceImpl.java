package com.demo.service;

import java.util.List;
import java.util.Optional;

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
		return edao.findAll();
	}

	@Override
	public void insertemp(Employee e) {
		edao.save(e);
		
	}

	@Override
	public Employee getById(int empid) {
		 Optional<Employee> op=edao.findById(empid);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
	}

	@Override
	public void updateemp(Employee e) {
		Optional<Employee> op=edao.findById(e.getEmpid());
		if(op.isPresent()) {
			Employee e1=op.get();
			e1.setEmpname(e.getEmpname());
		    e1.setSal(e.getSal());
			edao.save(e1);
			
		}
		
	}

	@Override
	public void deleteById(int empid) {
		// TODO Auto-generated method stub
		edao.deleteById(empid);
	}

}
