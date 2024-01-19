package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdcTemplate;
	
	@Override
	public List<Product> getAllProducts() {
		
		
		return jdcTemplate.query("select * from table45",(rs,num)->{
			
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setQty(rs.getInt(4));
			return p;
			
		});
		// TODO Auto-generated method stub
		

		
	}

	@Override
	public void save(Product p) {
		String str="insert into table45 values(?,?,?,?)";
		jdcTemplate.update(str,new Object[] {p.getPid(),
				p.getPname(),p.getPrice(),p.getQty()});
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		jdcTemplate.update("delete from table45 where pid=?",new Object[] {id});
		
	}

	@Override
	public Product getById(int pid) {
		try {
		    return jdcTemplate.queryForObject("select * from table45 where pid=?",new Object[] {pid},BeanPropertyRowMapper.newInstance(Product.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	
	
	@Override
	public void modifyProduct(Product product) {
		System.out.println("helll");
		jdcTemplate.update("update table45 set pname=?,qty=?,price=? where pid=?",
				new Object[] {product.getPname(),product.getQty(),product.getPrice(),product.getPid()});
		
	}

}
