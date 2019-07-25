package com.visa.training.bootpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.bootpro.dal.BookRepository;
import com.visa.training.bootpro.domain.Book;




@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository dao;
	@Override
	public int addNewBook(Book p) {
		// TODO Auto-generated method stub
		
		int id =0 ;
		if(p.getReleaseyear() >= 2009) {
			Book created = dao.save(p);
			id = created.getId();
		}
		else {
			throw new IllegalArgumentException("min year of book is 2009");
		}
		return id;
		
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book p) {
		// TODO Auto-generated method stub
		Book temp = dao.findById(p.getId());
		temp.setName(p.getName());
		temp.setAuthor(p.getAuthor());
		temp.setCategory(p.getCategory());
		temp.setReleaseyear(p.getReleaseyear());
		dao.save(temp);
	}
	
	

}
