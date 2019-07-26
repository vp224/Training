package com.visa.training.bootproject.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;

@Component
public class ProductConsoloeUI {
	
	ProductService service;
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	public void createProductWithUI() {
		Scanner s = new Scanner(System.in);
		System.out.println("eneter name");
		String name = s.nextLine();
		System.out.println("Enter price");
		float price = Float.parseFloat(s.nextLine());
		System.out.println("enter qoh");
		int qoh = Integer.parseInt(s.nextLine());
		Product p = new Product(name,price,qoh);
		try {
			int id = service.addNewProduct(p);
			System.out.println(id);
			
		}
		catch(IllegalArgumentException e) {
			System.out.println("value too low for creation");
		}
		
	}

}
