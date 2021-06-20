package com.Tamara.Firstmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.Firstmvc.models.Book;
import com.Tamara.Firstmvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks(){
		return this.bookRepository.findAll();
	}
	 public Book creatBook(Book book) {// Why i return a Book and why i use the bookRepository
		 return this.bookRepository.save(book); 
	 }
	 public Book findBook(Long id) {
		 Optional<Book> optionalBook = bookRepository.findById(id);
		 if(optionalBook.isPresent()) {
			 return optionalBook.get();
		 }else {
			 return null;
		 }
		 
	 }
	 public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages ) {
		 Book book = this.findBook(id);
		 if(book == null) {
			 return null;
		 }else {
			 book.setTitle(title);
			 book.setDescription(desc);
			 book.setLanguage(lang);
			 book.setNumberOfPages(numOfPages);
			 return this.creatBook(book); 
		 }
		  // should i use the save() and if i want to use it how
		 // the book is instance from Book class
		 //the bookRepository is an variable from the BookRepository
	 }
	 public void deleteBook(Long id) {
		 Book book = this.findBook(id);
		 this.bookRepository.delete(book);
//		 this.bookRepository.deleteById(id); can i do this and what is the different
	 }
	 public Book createBook(Book book) {
	        return bookRepository.save(book);
	    }

	
}
