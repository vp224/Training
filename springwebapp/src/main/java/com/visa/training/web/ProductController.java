package com.visa.training.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

//ProductService service;
//
//@Autowired
//public void setService(ProductService service) {
//	this.service = service;
//}
//public void createProductWithUI() {
//	Scanner s = new Scanner(System.in);
//	System.out.println("eneter name");
//	String name = s.nextLine();
//	System.out.println("Enter price");
//	float price = Float.parseFloat(s.nextLine());
//	System.out.println("enter qoh");
//	int qoh = Integer.parseInt(s.nextLine());
//	Product p = new Product(name,price,qoh);
//	try {
//		int id = service.addNewProduct(p);
//		System.out.println(id);
//		
//	}
//	catch(IllegalArgumentException e) {
//		System.out.println("value too low for creation");
//	}
//	
//}

@Controller
public class ProductController {
    
    @Autowired
    ProductService service;
    
    @Autowired
    ProductValidator validator;
    
    @RequestMapping(value="/products",method=RequestMethod.GET)
    public ModelAndView listProducts() {
    	Product product = new Product();
        List<Product> productList = service.findAll();
        Map<String,Object> attr = new HashMap<>();
        attr.put("productList", productList);
        attr.put("product", product);
        
        return new ModelAndView("productList", attr);
    }
    
    @RequestMapping(value="/products",method=RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product")Product p,Errors validationErrors) {
        //Product p = new Product(name, price, qoh);
    	validator.validate(p, validationErrors);
        if(!validationErrors.hasErrors()) {
            service.addNewProduct(p);
        }
        List<Product> productList = service.findAll();
        Map<String,Object> attr = new HashMap<>();
        attr.put("productList", productList);
        return new ModelAndView("productList", attr);
    }
    
    @RequestMapping("/removeProduct")
    public ModelAndView removeProduct(@RequestParam("id")int id) {
    	try {
            service.delete(id);
        }catch (IllegalArgumentException e) {
            return new ModelAndView("fail");
        }
        List<Product> productList = service.findAll();
        Map<String,Object> attr = new HashMap<>();
        attr.put("productList", productList);
        Product product = new Product();
        attr.put("product", product);
        return new ModelAndView("productList", attr);
    }
    
//    @ModelAttribute("productList")
//    public List<Product> getProductList(){
//        return service.findAll();
//    }

}

