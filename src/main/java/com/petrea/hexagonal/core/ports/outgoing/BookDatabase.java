package com.petrea.hexagonal.core.ports.outgoing;

import com.petrea.hexagonal.core.model.Book;

public interface BookDatabase {

	void saveBook(Book book);
	Book getBookByBookId(Long bookIdentifier);
	void deleteBook(Long bookIdentifier);
	
}
