package com.petrea.hexagonal.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petrea.hexagonal.core.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findBookByBookId(Long bookId);
}
