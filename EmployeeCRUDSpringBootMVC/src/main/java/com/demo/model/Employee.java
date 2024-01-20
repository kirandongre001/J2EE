package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employee1")
public class Employee {
 @Id
 private int empid;
 private String empname;
 private double sal;
 
public Employee() {
	super();
}

public Employee(int empid, String empname, double sal) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.sal = sal;
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

public double getSal() {
	return sal;
}

public void setSal(double sal) {
	this.sal = sal;
}

@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + ", sal=" + sal + "]";
}


}
