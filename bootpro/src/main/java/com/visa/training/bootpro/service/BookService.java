package com.visa.training.bootpro.service;

import java.util.List;

import com.visa.training.bootpro.domain.Book;

public interface BookService {
	public int addNewBook(Book p);
	public Book findById(int id);
	public List<Book> findAll();
	public void delete(int id);
	public void update(Book p);
}
