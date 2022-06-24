package com.cts.cartservice.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cartservice.CartServiceApplication;
import com.cts.cartservice.entity.Book;
import com.cts.cartservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	private static final Logger LOGGER =  LoggerFactory.getLogger(CartServiceApplication.class);
	@Autowired
	private CartService service;
	
	@GetMapping("/")
	public ResponseEntity<?> viewCart(){
		return service.viewCart();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addToCart(@RequestBody Book book){
		return service.addToCart(book);
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<?> updateCartItemQuantity(@PathVariable("bookId")Long bookId, @RequestParam("action") String action){
		LOGGER.warn("ACTION : " + action);
		return service.updateCartItemQuantity(bookId, action);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<?> removeFromCart(@PathVariable("bookId") Long bookId){
		return service.removeFromCart(bookId);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<?> emptyCart(){
		return service.emptyCart();
	}
	
}
