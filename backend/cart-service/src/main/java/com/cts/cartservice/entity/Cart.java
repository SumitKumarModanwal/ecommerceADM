package com.cts.cartservice.entity;

import java.util.List;


public class Cart {
	
	private List<CartItem> bookList;
	private Integer total;
	
	public Cart() {}
	
	public Cart(List<CartItem> bookList, Integer total) {
		super();
		this.bookList = bookList;
		this.total = total;
	}

	public List<CartItem> getBookList() {
		return bookList;
	}

	public void setBookList(List<CartItem> bookList) {
		this.bookList = bookList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [bookList=" + bookList + ", total=" + total + "]";
	}
	
	
	
}
