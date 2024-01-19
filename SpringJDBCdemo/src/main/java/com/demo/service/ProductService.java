package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	int addProduct();

	List<Product> displayAllProduct();

	Product displayById(int id);

	int deleteById(int id);

	int modifyProduct();

	Product displayByQty(int qty);

}
