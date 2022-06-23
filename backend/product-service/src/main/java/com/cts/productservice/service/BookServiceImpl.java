package com.cts.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.productservice.entity.Book;
import com.cts.productservice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public ResponseEntity<?> getAllBooks() {
		List<Book> bookList = bookRepository.findAllInStock();
		if(bookList != null && !bookList.isEmpty()) {
			return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> getBookByBookId(Long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		if(!book.isEmpty() && book.get() != null) {
			return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
}
