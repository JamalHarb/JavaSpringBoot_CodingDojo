package com.codingdojo.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByBorrower(User borrower);
	List<Book> findByBorrowerNull();
}
