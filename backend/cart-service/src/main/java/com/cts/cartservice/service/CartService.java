package com.cts.cartservice.service;

import org.springframework.http.ResponseEntity;

import com.cts.cartservice.entity.Book;

public interface CartService {
	
	ResponseEntity<?> viewCart();
	
	ResponseEntity<?> addToCart( Book book);
	
	ResponseEntity<?> updateCartItemQuantity(Long bookId, String action);
	
	ResponseEntity<?> removeFromCart(Long bookId);
	
	ResponseEntity<?> emptyCart();
}
