package com.cts.adminservice.service;

import org.springframework.http.ResponseEntity;

import com.cts.adminservice.entity.Book;

public interface BookService {
	ResponseEntity<?> getInventory();

	ResponseEntity<?> addBookToInventory(Book book);

	ResponseEntity<?> updateBookInInventory(Long bookId, Book book);
	
	ResponseEntity<?> removeBookFromInventory(Long bookId);
}
