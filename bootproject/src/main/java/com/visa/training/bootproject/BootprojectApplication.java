package com.visa.training.bootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootprojectApplication {

	public static void main(String[] args) {
		/*ApplicationContext springContainer = SpringApplication.run(BootProjectApplication.class, args);
        ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
        ui.createProductWithUI();*/
        
        SpringApplication.run(BootprojectApplication.class, args);
	}

}
