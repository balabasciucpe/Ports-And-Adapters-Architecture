package com.petrea.hexagonal.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petrea.hexagonal.core.ports.incoming.BookOperations;
import com.petrea.hexagonal.core.ports.outgoing.BookDatabase;
import com.petrea.hexagonal.core.service.BookService;

@Configuration
public class BookDomainConfig {

	@Bean
	public BookOperations bookOperations(BookDatabase database)
	{
		return new BookService(database);
	}
	
	@Bean
	public BookDatabase bookDatabase(BookRepository repository)
	{
		return new BookDatabaseAdapter(repository);
	}
	
	
	
}
