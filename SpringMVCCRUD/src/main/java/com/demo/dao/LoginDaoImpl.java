package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{

	
	@Autowired
	JdbcTemplate jbt;
	@Override
	public MyUser validate(String uname, String password) {
		// TODO Auto-generated method stub
		System.out.println("uname:"+uname+" "+"pass:"+password);
		try {
		String str="select uname,password from user45 where uname=? and password=?";
		return jbt.queryForObject(str,new Object[] {uname,password},BeanPropertyRowMapper.newInstance(MyUser.class));
		
	} catch (EmptyResultDataAccessException e)
		{
		System.out.println("not found"+e.getMessage());
		return null;
		}

}
}
