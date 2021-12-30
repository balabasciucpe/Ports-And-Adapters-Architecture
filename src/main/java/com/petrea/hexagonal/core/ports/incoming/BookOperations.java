package com.petrea.hexagonal.core.ports.incoming;

import org.springframework.stereotype.Component;

import com.petrea.hexagonal.core.model.AddBookCommand;
import com.petrea.hexagonal.core.model.Book;

//Use cases
@Component
public interface BookOperations {

	
	void addBook(AddBookCommand addBookCommand);
	void deleteBook(Long bookIdforDelete);
	Book getBookById(Long getBookById);
	
}
