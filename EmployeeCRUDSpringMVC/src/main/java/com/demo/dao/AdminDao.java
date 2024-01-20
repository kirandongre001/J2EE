package com.demo.dao;

import com.demo.model.Admin;

public interface AdminDao {

	Admin validate(String aname, String password);

}
