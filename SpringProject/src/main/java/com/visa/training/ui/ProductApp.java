package com.visa.training.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductApp {
		public static void main(String[] args) {
			//ProductConsoloeUI p = new ProductConsoloeUI();
			Class config[] = {ProductAppConfiguration.class,PersistenceJPAConfiguration.class};
			ApplicationContext springContainer = new AnnotationConfigApplicationContext(ProductAppConfiguration.class);
			ProductConsoloeUI p = springContainer.getBean(ProductConsoloeUI.class);
			p.createProductWithUI();
			
		}
}
