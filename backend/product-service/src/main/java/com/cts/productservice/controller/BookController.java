package com.cts.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.productservice.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<?> getBookByBookId(@PathVariable("bookId") Long bookId){
		return bookService.getBookByBookId(bookId);
	}
}
