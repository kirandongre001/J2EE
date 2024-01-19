package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	int insertProduct(Product p);

	List<Product> getAllProduct();

	Product getById(int id);

	int removeById(int id);

	int UpdateProduct(Product p);

	Product getByQty(int qty);

}
