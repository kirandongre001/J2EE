package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Employee> getAllEmployee() {

		return jt.query("select * from employee",BeanPropertyRowMapper.newInstance(Employee.class));
	}

	@Override
	public void insert(Employee e) {

		String s="insert into employee values(?,?,?)";
		jt.update(s,new Object[] {e.getEmpid(),e.getEmpname(),e.getSal()});

	}

	@Override
	public Employee getByid(int empid) {

		// TODO Auto-generated method stub
		try {
			return jt.queryForObject("select * from employee where empid=?",new Object[] {empid},BeanPropertyRowMapper.newInstance(Employee.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public void update(Employee e) {
		String s="update employee set empname=?,sal=? where empid=?";
		jt.update(s,new Object[] {e.getEmpname(),e.getSal(),e.getEmpid()});
		
	}

	@Override
	public void deleteById(int empid) {
		String s="delete from employee where empid=?";
		jt.update(s,new Object[] {empid});
	}
}
