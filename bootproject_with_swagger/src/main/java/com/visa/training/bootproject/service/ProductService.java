package com.visa.training.bootproject.service;

import java.util.List;

import com.visa.training.bootproject.domain.Product;



public interface ProductService {
	
	public int addNewProduct(Product p);
	public Product findById(int id);
	public List<Product> findAll();
	public void deleteProduct(int id);
	public void update(Product p);
	public void remove(int id);

}
