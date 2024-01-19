package com.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("1")
  private int empid;
	@Value("kiran")
  private String empname;
public Employee() {
	super();
}
public Employee(int empid, String empname) {
	super();
	this.empid = empid;
	this.empname = empname;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + "]";
}
  
}
