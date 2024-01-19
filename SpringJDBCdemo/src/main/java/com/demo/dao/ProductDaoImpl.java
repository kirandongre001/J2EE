package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	JdbcTemplate jt;

	public int insertProduct(Product p) {
		return jt.update("insert into product values(?,?,?,?)", new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		
	}

	public List<Product> getAllProduct() {
		
//		List<Product> ls= jt.query("select * from product", new RowMapper<Product>() {
//			public Product mapRow(ResultSet rs, int num) throws SQLException {
//				Product p=new Product();
//				p.setPid(rs.getInt(1));
//				p.setPname(rs.getString(2));
//			 	p.setQty(rs.getInt(3));
//				p.setPrice(rs.getDouble(4));
//				return p;
//			}
//		});
		
		
//		List<Product> ls= jt.query("select * from product", (rs,num)->{
//				Product p=new Product();
//				p.setPid(rs.getInt(1));
//				p.setPname(rs.getString(2));
//				p.setQty(rs.getInt(3));
//				p.setPrice(rs.getDouble(4));
//				return p;
//			});
		
		List<Product> ls=jt.query("select * from product", BeanPropertyRowMapper.newInstance(Product.class) );
		return ls;
	}

	@Override
	public Product getById(int id) {
		
		Product p=jt.queryForObject("select * from Product where pid=?", new Object[] {id},BeanPropertyRowMapper.newInstance(Product.class));
		
		return p;
	}

	@Override
	public int removeById(int id) {
		
		int n=jt.update("delete from product where pid=?",new Object[] {id});
		
		return n;
	}

	@Override
	public int UpdateProduct(Product p) {
		int n=jt.update("update product set pid=?,pname=?,qty=?,price=?",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		return n;
	}

	@Override
	public Product getByQty(int qty) {
		Product p=jt.queryForObject("select * from product where qty=?",new Object[] {qty}, BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	
	
}
