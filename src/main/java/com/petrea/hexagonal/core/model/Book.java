package com.petrea.hexagonal.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	//for Hibernate
	public Book() {}

	//setting things in our constructor only
	public Book(String authorName, String bookTitle) {
		this.authorName = authorName;
		this.bookTitle = bookTitle;
	}

	public Long getBookId() {
		return bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getBookTitle() {
		return bookTitle;
	}
	
	

	
	
	
}
