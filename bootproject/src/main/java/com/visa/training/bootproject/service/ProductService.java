package com.visa.training.bootproject.service;
//import com.visa.training.bootproject.domain.*;
import java.util.List;

import com.visa.training.bootproject.domain.Product;

public interface ProductService {
		public int addNewProduct(Product p);
		public Product findById(int id);
		public List<Product> findAll();
		public void delete(int id);
		public void update(Product p);
		
}
