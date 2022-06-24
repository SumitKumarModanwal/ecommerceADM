package com.cts.cartservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cart")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long cartItemId;
	@Column(nullable = false)
	@JsonIgnore
	private Long userId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "book_id", referencedColumnName = "bookId")
	private Book book;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Integer subTotal;
	
	public CartItem() {}
	
	public CartItem(Long cartItemId, Book book, Integer quantity, Integer subTotal) {
		super();
		this.cartItemId = cartItemId;
		this.book = book;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", book=" + book + ", quantity=" + quantity + ", subTotal="
				+ subTotal + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
}
