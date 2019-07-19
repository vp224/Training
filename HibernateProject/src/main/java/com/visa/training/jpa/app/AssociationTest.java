package com.visa.training.jpa.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JPAUtil;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.Address;
import com.visa.training.jpa.domain.CurrentAccount;
import com.visa.training.jpa.domain.Customer;
import com.visa.training.jpa.domain.SavingsAccount;

public class AssociationTest {
	public static void main(String[] args) {
		//createAccountandCustomerSeperately();
		//readAccountwithCustomer();
		
		//createAccountandCustomerTogether();
		//testLazy();
		
		testManyToMany();
		System.exit(0);
	}
	private static void testManyToMany() {
		EntityManager em = JPAUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer c = new Customer("ffn","mmn","lln",new Date(System.currentTimeMillis()));
		Address a = new Address("s11","s22","blr","ka","vp","fp");
		c.getAdd().add(a);
		em.persist(c);
		tx.commit();
		em.close();
	}
	
	private static void testLazy() {
		EntityManager em = JPAUtil.getEmf().createEntityManager();
		Customer c1 = em.find(Customer.class,39);//persistent state
		
		//select from account where cust_id =39 to get accounts, should it load accounts?
		//dB fucked in case of bidirectional if u load both the items here itself
		
		em.close();//detached
		System.out.println(c1.getFirstname());
		
		Account a = c1.getAccounts().get(0);//working with detached object
		System.out.println(a.getBalance());
		
	}
	public static void createAccountandCustomerSeperately() {
		EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer c =new Customer("fn","mmn","ln",new Date(System.currentTimeMillis()));
        SavingsAccount s = new SavingsAccount(10000);
        em.persist(c);
        s.setCustomer(c);//otherwise cust_id for select * from account; will be null
        em.persist(s);
        tx.commit();
        
        em.close();
	}
	public static void readAccountwithCustomer() {
		EntityManager em = JPAUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        SavingsAccount s= em.find(SavingsAccount.class,39);
        System.out.println(s.getCustomer().getFirstname());
	}
	
		private static void createAccountandCustomerTogether() {
	        EntityManager em = JPAUtil.getEmf().createEntityManager();
	        EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        
	        Customer c = new Customer("fn", "mmn", "ln", new Date(System.currentTimeMillis()));
	        SavingsAccount sa = new SavingsAccount(1234);
	        
	        sa.setCustomer(c);
	        //em.persist(c);
	        em.persist(sa);
	        
	        tx.commit();
	        em.close();
	        
	    
	}
}
