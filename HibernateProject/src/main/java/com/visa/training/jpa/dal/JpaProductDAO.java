package com.visa.training.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.visa.training.jpa.domain.Product;

public class JpaProductDAO {
	public Product save(Product p) {
		EntityManagerFactory emf = JPAUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction tx =em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return p;
		//in jdbc1 auto commit was true by default
		
		
	}
	
	public Product findbyId(int id) {
		Product p = null;
		EntityManager em = JPAUtil.getEmf().createEntityManager();
		try{
			
			p = em.find(Product.class, id);
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
		return p;
	}
	
	
	public void remove(int id) {
		Product p=null;
		EntityManager em  = JPAUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx =em.getTransaction();
			p = em.find(Product.class, id);
			tx.begin();
			if(p!=null)
				em.remove(p);
			tx.commit();
		}
		finally {
			em.close();
		}
	}
	
	public void update(Product t) {
		
		EntityManager em  = JPAUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx =em.getTransaction();
			tx.begin();
			em.merge(t);
			tx.commit();
		}
		finally {
			em.close();
		}
	}
	
	public List<Product> findByPriceGreaterThan(Float     f)
	{
		EntityManager em  = JPAUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from product as p where p.price > :priceparam");
		//a.customer_name.first_name 
		
		q.setParameter("priceparam", f);
		//q.setParameter(1,f);
		List<Product> all = q.getResultList();
		em.close();
		return all;
		
	}
	public List<Product> findAll(){
		EntityManager em  = JPAUtil.getEmf().createEntityManager();
		Query q =em.createQuery("select p from product as p");//JPQL uses entity class names and field names
		List<Product> all = q.getResultList();
		
		em.close();
		return all;
	}
	
	
}
