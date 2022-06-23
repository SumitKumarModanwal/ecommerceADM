package com.cts.productservice.service;

import org.springframework.http.ResponseEntity;

public interface BookService {
	ResponseEntity<?> getAllBooks();

	ResponseEntity<?> getBookByBookId(Long bookId);
}
