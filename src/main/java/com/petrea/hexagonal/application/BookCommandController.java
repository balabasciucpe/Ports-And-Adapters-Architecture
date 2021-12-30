package com.petrea.hexagonal.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrea.hexagonal.core.model.AddBookCommand;
import com.petrea.hexagonal.core.model.Book;
import com.petrea.hexagonal.core.ports.incoming.BookOperations;

@RestController
@RequestMapping(value = "/books")
public class BookCommandController {

	private BookOperations bookOperations;

	public BookCommandController(BookOperations bookOperations) {
		this.bookOperations = bookOperations;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable ("id") Long bookIdentifier)
	{
		return new ResponseEntity<Book>(bookOperations.getBookById(bookIdentifier), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<String> addBook(@RequestBody AddBookCommand addBookCommnad)
	{
		bookOperations.addBook(addBookCommnad);
		return new ResponseEntity<>("Book was added in the DB", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteEntity(@PathVariable ("id") Long bookIdentifier)
	{
		bookOperations.deleteBook(bookIdentifier);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
}
