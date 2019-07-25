package com.visa.training.bootpro.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
		@Id
		@Column(name = "book_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		int id;
		
		@Column(name = "book_name")
		String name;
		
		@Column(name = "book_author")
		String author;
		
		@Column(name = "book_category")
		String category;
		
		@Column(name = "book_releaseyear")
		int releaseyear;
		
		@OneToMany(mappedBy = "book",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
		List<Chapter> chapters = new ArrayList<>();

		public Book() {
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getReleaseyear() {
			return releaseyear;
		}
		public void setReleaseyear(int releaseyear) {
			this.releaseyear = releaseyear;
		}
		public List<Chapter> getChapters() {
			return chapters;
		}
		public void setChapters(List<Chapter> chapters) {
			this.chapters = chapters;
		}
		public Book(int id, String name, String author, String category, int releaseyear, List<Chapter> chapters) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
			this.category = category;
			this.releaseyear = releaseyear;
			this.chapters = chapters;
		}
}
