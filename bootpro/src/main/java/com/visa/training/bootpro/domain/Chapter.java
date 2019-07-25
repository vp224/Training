package com.visa.training.bootpro.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chapter")
public class Chapter {

	@Id
	@Column(name = "chapter_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "chapter_index")
	int index;
	
	@Column(name = "chapter_name")
	String name;
	
	@Column(name = "chapter_numpages")
	int numpages;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="book_id")
	Book book;
	public Chapter() {
		
	}

	public Chapter(int id, int index, String name, int numpages) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.numpages = numpages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumpages() {
		return numpages;
	}

	public void setNumpages(int numpages) {
		this.numpages = numpages;
	}
	
	
}
