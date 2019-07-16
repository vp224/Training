package com.visa.training.jdbc;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOTest {
		public static void main(String[] args) throws SQLException {
			Product       p = new Product(12346,"gre",(float) 123.56,10); // can call without giving id
			
			ProductDAO n = new ProductDAO();
			int genId = n.save(p);
			System.out.println(genId);
			
			Product v = n.findbyId(genId);
			System.out.println(v.toString());
			
			
			List<Product> r = n.findAll();
			r.forEach(System.out::println);
			System.out.println("----------------------");
			n.remove(genId);
			
			List<Product> s = n.findAll();
			s.forEach(System.out::println);
			
			Product temp = new Product(12348,"name",(float)123.9,90);
			n.update(temp);
			
		}
}
