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
	
	static PreparedStatement disAll,instdata,getId,updatedata,deldata;
	
	static
	{
		
		try {
			  conn=DBUtil.getMyConnection();
			disAll=conn.prepareStatement("select * from Employee45;");
			instdata=conn.prepareStatement("insert into Employee45 values(?,?,?)");
			getId=conn.prepareStatement("select * from Employee45 where empId=?");
			updatedata=conn.prepareStatement("update Employee45 set empName=?,sal=? where empId=?");
			deldata=conn.prepareStatement("delete from Employee45 where empId=?");
			
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

@Override
	public Employee getById(int id) {
		try {
			getId.setInt(1,id);
			ResultSet rs= getId.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(id));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null ;
	}


@Override
public void updateemp(Employee e) {
	try {
		updatedata.setString(1, e.getEmpName());
		updatedata.setDouble(2, e.getSal());
		updatedata.setInt(3, e.getEmpId());
		
		updatedata.executeUpdate();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}


@Override
public void deleteemp(int id) {
	try {
		deldata.setInt(1, id);
		
		deldata.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
