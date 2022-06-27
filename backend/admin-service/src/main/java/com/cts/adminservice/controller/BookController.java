package com.cts.adminservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.adminservice.entity.Book;
import com.cts.adminservice.service.BookService;

@RestController
@RequestMapping("/admin/inventory")
public class BookController {
	private static final Logger LOGGER = LoggerFactory.getLogger("BOOK CONTROLLER - ADMIN");
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public ResponseEntity<?> getInventory() {
		return bookService.getInventory();
	}
	
	@PostMapping("")
	public ResponseEntity<?> addBookToInventory(@RequestBody Book book){
		LOGGER.warn(book.toString());
		return bookService.addBookToInventory(book);
	}
	
	// TODO - ADD File type in params
	@PutMapping("/{bookId}/uploadImage")
	public ResponseEntity<?> uploadImage(@PathVariable("bookId") Long bookId) {
		return null;
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<?> updateBookInInventory(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
		return bookService.updateBookInInventory(bookId, book);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<?> removeBookFromInventory(@PathVariable("bookId") Long bookId){
		return bookService.removeBookFromInventory(bookId);
	}
}
