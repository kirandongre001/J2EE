package com.demo.service;

import com.demo.model.Admin;

public interface AdminService {

	Admin validate(String aname, String password);

	void register(Admin ad);

}
