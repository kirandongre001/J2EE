package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	void save(Product p);

	void deleteById(int id);

	Product getById(int pid);

	void modifyProduct(Product product);

	
	

}
