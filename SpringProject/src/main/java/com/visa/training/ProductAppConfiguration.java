package com.visa.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.visa.training.dal.ProductDAO;
import com.visa.training.dal.ProductDAOInMemimpl;
import com.visa.training.service.ProductService;
import com.visa.training.service.ProductServiceimpl;

@Configuration
@ComponentScan(basePackages = "com.visa.training")
public class ProductAppConfiguration {
	
	
	
//	@Bean
//	public ProductDAO dao() {
//		return new ProductDAOInMemimpl();
//	}
//	@Bean
//	public ProductService service() {
//		ProductServiceimpl service = new ProductServiceimpl();
//		service.setDao(dao());
//		return service;
//	}
//	
//	@Bean
//	public ProductConsoloeUI ui() {
//		ProductConsoloeUI ui = new ProductConsoloeUI();
//		ui.setService(service());
//		return ui;
//	}
}
