package com.visa.training.bootpro.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.training.bootpro.domain.Book;


@Repository
@Transactional
public class BookDAOJpaImpl implements BookDAO{

	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public Book save(Book p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p;
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Book.class, id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		List<Book> books = em.createQuery("select p from book as p").getResultList();
		return books;
	}

	@Override
	public void update(Book p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		Book p = findById(id);
		em.remove(p);
	}
	
	

}
