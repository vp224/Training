package com.visa.training.bootpro.dal;

import java.util.List;

import com.visa.training.bootpro.domain.Book;

public interface BookDAO {
	
	public Book save(Book p);
	public Book findById(int id);
	public List<Book> findAll();
	public void update(Book p);
	public void remove(int id);

}
