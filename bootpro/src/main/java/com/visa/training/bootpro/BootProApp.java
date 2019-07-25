package com.visa.training.bootpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BootProApp {
	public static void main(String[] args) {
		/*ApplicationContext springContainer = SpringApplication.run(BootProjectApplication.class, args);
        ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
        ui.createProductWithUI();*/
        
        SpringApplication.run(BootProApp.class, args);
	}

}
