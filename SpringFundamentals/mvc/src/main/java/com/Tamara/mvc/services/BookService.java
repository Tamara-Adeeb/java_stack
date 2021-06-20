package com.Tamara.mvc.services;
import java.util.Optional;

import com.Tamara.mvc.models.Book;
import com.Tamara.mvc.repositories.BookRepository;

public class BookService {
	private final BookRepository bookRepository;
	
	
	
	
	public Book updateBook(long id, String title, String desc, String lang,Integer numOfPages) {
		Optional<Book> book = bookRepository.findById(id);
		 if(book.isPresent()) {
	           book.get();
	           book.setTitle(title);
	           book.set
	        } else {
	            return null;	
	        }
		book.title = title;
		
		return bookRepository.save(b);
	}
	public void deleteBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}
