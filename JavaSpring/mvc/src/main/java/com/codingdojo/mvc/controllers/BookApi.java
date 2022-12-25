package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@RestController
public class BookApi {
	private final BookService bookService;
	public BookApi(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	@PostMapping("/api/books")
	public Book createBook(
			@RequestParam(value="title") String title,
			@RequestParam(value="desc") String desc,
			@RequestParam(value="lang") String lang,
			@RequestParam(value="pages") Integer pages) {
		Book b = new Book(title, desc, lang, pages);
		return bookService.createBook(b);
	}
	@RequestMapping("/api/books/{id}")
	public Book displayBook(@PathVariable("id") long id) {
		return bookService.findBook(id);
	}
	@RequestMapping("/api/books/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		bookService.deleteBook(id);
	}
	@PostMapping("/api/books/update/{id}")
	public Book update(
			@PathVariable("id") long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="desc") String desc,
			@RequestParam(value="lang") String lang,
			@RequestParam(value="pages") Integer pages) {
		return bookService.updateBook(id, title, desc, lang, pages);
	}
}
