package com.visa.training.bootproject.dal;
import com.visa.training.bootproject.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.visa.training.bootproject.domain.Product;
//@Repository
public class ProductDAOInMemimpl implements ProductDAO{
	int idSequence;
	Map<Integer, Product> data = new HashMap<Integer,Product>();

	public Product save(Product p) {
		// TODO Auto-generated method stub
		int id = ++idSequence;
		p.setId(id);
		data.put(id, p);
		return p;
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Product>(data.values());
	}

	public void update(Product p) {
		// TODO Auto-generated method stub
		data.put(p.getId(), p);
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		data.remove(id);
	}
	

}
