package com.bluewind.errorhandling.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.errorhandling.exception.BookNotFoundException;
import com.bluewind.errorhandling.model.Book;

@RestController
public class BookController {
	private static Map<Long, Book> books = new HashMap<>();
	
	static {
		Book book1 = new Book();
		book1.setId(1);
		book1.setName("Journey West");
		book1.setAuthor("Wu chengen");
		
		Book book2 = new Book();
		book2.setId(2);
		book2.setName("Three countries");
		book2.setAuthor("Luo guanzhong");
		
		books.put(book1.getId(), book1);
		books.put(book2.getId(), book2);
	}
	
	@GetMapping("/books")
	public Collection<Book> getAllBooks(){
		return books.values();
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable long id) {
		Book book = books.get(id);
		if(book == null) {
			throw new BookNotFoundException("No book id : " + id);
		}
		
		return book;
	}
}
