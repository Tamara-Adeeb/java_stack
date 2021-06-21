package com.Tamara.Firstmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Tamara.Firstmvc.models.Book;
import com.Tamara.Firstmvc.services.BookService;

@Controller
public class BooksShow {
	private final BookService bookService;
	
	public BooksShow(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id,Model model, HttpSession session) {
		model.addAttribute("book", this.bookService.findBook(id)); //Why there is No id inside this object how can i have it
		model.addAttribute("book_id", id);
		return "show.jsp";
	}
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id,Model model) {
		model.addAttribute("book", this.bookService.findBook(id));
		model.addAttribute("book_id", id);
		return "edit.jsp";
	}
	@RequestMapping(value="/books/{id}",method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		this.bookService.updateBook(book);
		return "redirect:/books";
	}
	@RequestMapping("/books")
    public String index(Model model) {
		model.addAttribute("all_Books", bookService.allBooks());
        return "AllBooks.jsp";
    }
	
}
