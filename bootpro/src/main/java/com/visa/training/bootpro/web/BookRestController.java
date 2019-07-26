package com.visa.training.bootpro.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.bootpro.domain.Book;
import com.visa.training.bootpro.service.BookService;



@RestController
public class BookRestController {
	@Autowired
	BookService service;
	
	@RequestMapping(value="/api/books", method = RequestMethod.GET)
	public List<Book> getAll(){
		return service.findAll();
	}
	
	@RequestMapping(value ="/api/books/{id}",method = RequestMethod.GET)
	public ResponseEntity<Book> getById(@PathVariable("id")int id){
		Book p =service.findById(id);
		if(p!= null) {
			return new ResponseEntity<Book>
(p,HttpStatus.OK);		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value ="/api/books",method=RequestMethod.POST)
	public ResponseEntity createProduct(@RequestBody Book toBeCreated) {
		try {
			toBeCreated.getChapters().forEach(e -> e.setBook(toBeCreated));
			int id = service.addNewBook(toBeCreated);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/books/"+id));
			return new ResponseEntity<>(headers,HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@RequestMapping(value = "/api/books/{id}",method  = RequestMethod.PUT)
	public ResponseEntity updateProduct(@RequestBody Book tobeDeleted , @PathVariable("id") int id) {
		Book s = service.findById(id);
		
		if(s!=null) {
			tobeDeleted.getChapters().forEach(e -> e.setBook(tobeDeleted));
			
			service.update(tobeDeleted,id);
			return new ResponseEntity<>(HttpStatus.CREATED);
			
		}
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}


