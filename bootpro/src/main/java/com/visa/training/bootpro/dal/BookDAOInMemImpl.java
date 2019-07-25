package com.visa.training.bootpro.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.visa.training.bootpro.domain.Book;
import com.visa.training.bootpro.domain.Book;

public class BookDAOInMemImpl implements BookDAO{

	int idSequence;
	Map<Integer, Book> data = new HashMap<Integer,Book>();
	
	@Override
	public Book save(Book p) {
		// TODO Auto-generated method stub
		int id = ++idSequence;
		p.setId(id);
		data.put(id, p);
		return p;
		
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Book>(data.values());
	}

	@Override
	public void update(Book p) {
		// TODO Auto-generated method stub
		data.put(p.getId(), p);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		data.remove(id);
	}
	
	

}
