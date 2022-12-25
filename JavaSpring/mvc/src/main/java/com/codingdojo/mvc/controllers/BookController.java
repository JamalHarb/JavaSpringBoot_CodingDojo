package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books.jsp";
    }
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show_book.jsp";
	}
	@PostMapping("/add_book")
	public String addBook(
			@RequestParam(value="title") String title,
			@RequestParam(value="desc") String desc,
			@RequestParam(value="lang") String lang,
			@RequestParam(value="pages") Integer pages) {
		Book book = new Book(title, desc, lang, pages);
		bookService.createBook(book);
		return "redirect:/books";
	}
	
}
