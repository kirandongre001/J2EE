package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.*;


import com.demo.model.Employee;

public class EmpDaoImpl implements EmpDao{

	static Connection conn;
	
	static PreparedStatement disAll,instdata;
	
	static
	{
		
		try {
			  conn=DBUtil.getMyConnection();
			disAll=conn.prepareStatement("select * from Employee45;");
			instdata=conn.prepareStatement("insert into Employee45 values(?,?,?)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Employee> displayAllEmp() {
		
		List<Employee>elist=new ArrayList<Employee>();
		
		try {
			ResultSet rs=disAll.executeQuery();
			
			while(rs.next())
			{
				Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				System.out.println(e);
				elist.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elist.forEach(System.out::println);
		return elist;
		
		
		
	}


	@Override
	public void insertEmployee(Employee e) {
		try {
			instdata.setInt(1, e.getEmpId());
			instdata.setString(2, e.getEmpName());
			instdata.setDouble(3, e.getSal());
			
			instdata.executeUpdate();
		} catch (SQLException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
