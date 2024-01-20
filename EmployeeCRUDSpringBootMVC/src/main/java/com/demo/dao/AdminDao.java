package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Admin;

public interface AdminDao extends JpaRepository<Admin, String> {

	@Query(value="select * from admin1 where aname=aname and password=password",nativeQuery = true)
	Admin validate(String aname, String password);

}
