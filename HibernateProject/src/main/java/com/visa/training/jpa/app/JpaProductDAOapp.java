package com.visa.training.jpa.app;

import java.util.List;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.Product;

public class JpaProductDAOapp {
		public static void main(String[] args)
		{
			JpaProductDAO dao = new JpaProductDAO();
//	        Product test = new Product("hibernate", 9999, 1000);
//	        Product saved = dao.save(test);
//	        System.out.println(saved);
//	        int a =12356;
//	        dao.remove(a);
//	        
//	        Product t = dao.findbyId(saved.getId());
//	        System.out.println(saved == t); // prints false as they are detached as soon as they get out of the function
//	        System.out.println(t.toString());
//	        
//	        t.setPrice(t.getPrice()+10);
//	        
//	        
//	        dao.update(t);
//	        Product te = dao.findbyId(t.getId());
//	        System.out.println(te);
	        
	        List<Product> res = dao.findAll();
	        res.forEach(System.out::println);
	        
	        List<Product> res1=dao.findByPriceGreaterThan(9999.0F);
	        res1.forEach(System.out::println);
	        }
}
