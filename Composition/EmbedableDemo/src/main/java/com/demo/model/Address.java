package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address45")
public class Address {
	
	@Id
	
	private int addid;
	
	private String street;
	
	private String city;
	
	public Address()
	{
		super();
	}
	
	

}
