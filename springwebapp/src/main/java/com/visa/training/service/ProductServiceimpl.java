package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;


@Service
public class ProductServiceimpl implements ProductService{
	
	
	ProductDAO dao;
	@Override
	public int addNewProduct(Product p) {
		// TODO Auto-generated method stub
		int id =0 ;
		if(p.getPrice() * p.getQoh() >=10000) {
			Product created = dao.save(p);
			id = created.getId();
		}
		else {
			throw new IllegalArgumentException("min value of stock should be at least 10k");
		}
		return id;
	}
	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Product p =dao.findById(id);
		if(p.getQoh() > 1000) {
			throw new IllegalArgumentException("cant remove value >1000");
		}
		else {
			dao.remove(id);
		}
	}
	

}
