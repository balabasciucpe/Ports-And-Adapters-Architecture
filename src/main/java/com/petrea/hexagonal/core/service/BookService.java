package com.petrea.hexagonal.core.service;

import com.petrea.hexagonal.core.model.AddBookCommand;
import com.petrea.hexagonal.core.model.Book;
import com.petrea.hexagonal.core.ports.incoming.BookOperations;
import com.petrea.hexagonal.core.ports.outgoing.BookDatabase;

public class BookService implements BookOperations {

	private final BookDatabase bookDatabase;
	
	public BookService(BookDatabase bookDatabase) {
		this.bookDatabase = bookDatabase;
	}
	

	@Override
	public void addBook(AddBookCommand addBookCommand) {
		Book book = new Book(addBookCommand.getAuthorName(), addBookCommand.getAuthorName());
		bookDatabase.saveBook(book);
	}

	@Override
	public void deleteBook(Long bookIdforDelete) {
		bookDatabase.deleteBook(bookIdforDelete);
		
	}

	@Override
	public Book getBookById(Long getBookById) {
		// TODO Auto-generated method stub
		return bookDatabase.getBookByBookId(getBookById);
	}
}
