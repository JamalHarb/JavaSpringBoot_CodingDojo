package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;


@Controller
public class AppController {
	
	private final UserService userService;
	private final BookService bookService;
	public AppController(UserService userService, BookService bookService) {
		this.userService = userService;
		this.bookService = bookService;
	}
	
	@GetMapping("")
	public String index(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser loginUser) {
        return "index.jsp";
    }
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		userService.register(newUser, result);
		if(result.hasErrors()) { 
            model.addAttribute("newLogin", new LoginUser()); 
            return "index.jsp";
        }
		session.setAttribute("user", newUser);
		return "redirect:/books";
	}
	
	@PostMapping("/login")
    public String login(
    		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result,
            Model model,
            HttpSession session) {
        User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user", user);
        return "redirect:/books";
    }
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { 
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/books")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
        	model.addAttribute("books", bookService.allBooks());
        	return "home.jsp";
        }
        else {
            return "redirect:/";
        }
    }
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new_book.jsp";
	}
	
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "new_book.jsp";
		}
		else {
			bookService.create(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") Long id) {
		model.addAttribute("book", bookService.findBook(id));
		return "show_book.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@ModelAttribute("book") Book book, Model model, @PathVariable("id") Long id) {
		model.addAttribute("book", bookService.findBook(id));
		return "edit_book.jsp";
	}
	
	@PostMapping("/books/{id}/update")
	public String updateBook(
			@PathVariable("id") Long id,
			Model model,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit_book.jsp";
		}
		else {
			bookService.update(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
	@GetMapping("/bookmarket")
	public String bookMarket(Model model, HttpSession session) {
		User borrower = (User) session.getAttribute("user");
		model.addAttribute("notBorrowedBooks", bookService.notBorrowedBooks());
		model.addAttribute("borrowedBooks", bookService.borrowedBooks(borrower));
		return "bookmarket.jsp";
	}
	
	@GetMapping("/bookmarket/borrow/{bookId}")
	public String borrow(HttpSession session, @PathVariable("bookId") Long id) {
		User borrower = (User) session.getAttribute("user");
		Book book = bookService.findBook(id);
		book.setBorrower(borrower);
		bookService.update(book);
		return "redirect:/bookmarket";
	}
	
	@GetMapping("/bookmarket/unborrow/{bookId}")
	public String unborrow(@PathVariable("bookId") Long id) {
		Book book = bookService.findBook(id);
		book.setBorrower(null);
		bookService.update(book);
		return "redirect:/bookmarket";
	}
	
}
