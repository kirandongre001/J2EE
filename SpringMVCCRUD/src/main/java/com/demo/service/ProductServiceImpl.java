package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao pdao;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.getAllProducts();
	}

	
	@Override
	public void addnewProduct(Product p) {
		pdao.save(p);
		
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		 pdao.deleteById(id);
	}


	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.getById(pid);
	}


	@Override
	public void updateById(Product product) {
		pdao.modifyProduct(product);
		
	}
}


