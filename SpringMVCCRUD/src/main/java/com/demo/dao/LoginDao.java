package com.demo.dao;

import com.demo.model.MyUser;

public interface LoginDao {

	MyUser validate(String uname, String password);

}
