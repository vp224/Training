package com.visa.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.training.ui.ProductConsoloeUI;

public class ProductApp {
		public static void main(String[] args) {
			//ProductConsoloeUI p = new ProductConsoloeUI();
			Class config[] = {ProductAppConfiguration.class,PersistenceJPAConfiguration.class};
			ApplicationContext springContainer = new AnnotationConfigApplicationContext(ProductAppConfiguration.class);
			ProductConsoloeUI p = springContainer.getBean(ProductConsoloeUI.class);
			p.createProductWithUI();
			
		}
}
