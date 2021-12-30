package com.petrea.hexagonal.infrastructure;

import com.petrea.hexagonal.core.model.Book;
import com.petrea.hexagonal.core.ports.outgoing.BookDatabase;

public class BookDatabaseAdapter implements BookDatabase {

	private BookRepository bookRepo;

	public BookDatabaseAdapter(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookRepo.save(book);
	}

	@Override
	public Book getBookByBookId(Long bookIdentifier) {
		// TODO Auto-generated method stub
		return bookRepo.findBookByBookId(bookIdentifier);
	}

	@Override
	public void deleteBook(Long bookIdentifier) {
		bookRepo.deleteById(bookIdentifier);
	}
}
