package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public Admin validate(String aname, String password) {

		try {
			String q="select * from admin where aname=? and password=?";
			return jt.queryForObject(q,new Object[]{aname,password},BeanPropertyRowMapper.newInstance(Admin.class));
		}catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
