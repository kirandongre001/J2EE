package com.demo.service;

import java.util.List;

import com.demo.model.Product;


public interface ProductService {

	List<Product> getAllProducts();

	void addnewProduct(Product p);

	void deleteById(int id);

	Product getById(int pid);

	void updateById(Product product);

}
