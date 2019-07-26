package com.visa.training.bootproject.dal;
//com.visa.training.bootproject.domain.*;
import java.util.List;

import com.visa.training.bootproject.domain.Product;

public interface ProductDAO {
	public Product save(Product p);
	public Product findById(int id);
	public List<Product> findAll();
	public void update(Product p);
	public void remove(int id);
}
