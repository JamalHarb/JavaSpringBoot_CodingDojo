package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }
        else {
            return null;
        }
    }
    public void deleteBook(long id) {
    	bookRepository.deleteById(id);
    }
    public Book updateBook(long id, String title, String desc, String lang, Integer pages) {
    	Book book = findBook(id);
    	if(book != null) {
    		book.setTitle(title);
    		book.setDescription(desc);
    		book.setLanguage(lang);
    		book.setNumberOfPages(pages);
    		return bookRepository.save(book);    		
    	}
    	else {
    		System.out.println("Couldn't find a book for the given id.");
    		return null;
    	}
    }
}
