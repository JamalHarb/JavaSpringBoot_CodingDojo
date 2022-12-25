package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
	public boolean delete(Long id) {
		bookRepo.deleteById(id);
		boolean isFound = bookRepo.existsById(id);
		return !isFound;
	}
	
	public Book update(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> borrowedBooks(User borrower) {
		return bookRepo.findByBorrower(borrower);
	}
	
	public List<Book> notBorrowedBooks() {
		return bookRepo.findByBorrowerNull();
	}
}
