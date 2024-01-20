package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="admin1")
public class Admin {
 @Id
 private String aname;
 private String password;
public Admin() {
	super();
}
public Admin(String aname, String password) {
	super();
	this.aname = aname;
	this.password = password;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [aname=" + aname + ", password=" + password + "]";
}


}
