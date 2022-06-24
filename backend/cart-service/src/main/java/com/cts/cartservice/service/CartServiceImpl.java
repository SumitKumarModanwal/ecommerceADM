package com.cts.cartservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.cartservice.CartServiceApplication;
import com.cts.cartservice.entity.Book;
import com.cts.cartservice.entity.Cart;
import com.cts.cartservice.entity.CartItem;
import com.cts.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(CartServiceApplication.class);

	@Autowired
	private CartRepository repository;
	private Long sessionUserId = 16L;

	@Override
	public ResponseEntity<?> viewCart() {

		List<CartItem> cartItems = repository.findByUserId(sessionUserId);
		if (cartItems != null && !cartItems.isEmpty()) {
			Cart cart = new Cart();
			cart.setBookList(cartItems);
			int total = 0;
			for (CartItem item : cartItems) {
				total += item.getSubTotal();
			}
			cart.setTotal(total);
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> addToCart(Book book) {
		CartItem cartItem = new CartItem();
		cartItem.setUserId(sessionUserId);
		cartItem.setBook(book);
		cartItem.setQuantity(1);
		cartItem.setSubTotal(book.getPrice());

		repository.save(cartItem);
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<?> updateCartItemQuantity(Long bookId, String action) {
		CartItem cartItem = repository.findByBookIdAndUserId(bookId, sessionUserId);
		if(cartItem != null) {
			if(action.equals("ADD")) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				repository.save(cartItem);
				return new ResponseEntity(HttpStatus.OK);
			} else if(action.equals("REMOVE")) {
				cartItem.setQuantity(cartItem.getQuantity() - 1);
				repository.save(cartItem);
				return new ResponseEntity(HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> removeFromCart(Long bookId) {
		CartItem cartItem = repository.findByBookIdAndUserId(bookId, sessionUserId);
		if(cartItem != null) {
			repository.delete(cartItem);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> emptyCart() {
		List<CartItem> cartItems = repository.findByUserId(sessionUserId);
		repository.deleteAll(cartItems);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
