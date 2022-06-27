package com.cts.orderservice.entity;

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
@Table(name = "OrderItem")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long orderItemId;
	@Column(nullable = false)
	@JsonIgnore
	private Long orderId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "book_id", referencedColumnName = "bookId")
	private Book book;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Integer subTotal;
	
	public OrderItem() {}
	
	public OrderItem(Long orderItemId,Long orderId, Book book, Integer quantity, Integer subTotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.book = book;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
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
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", book=" + book + ", quantity="
				+ quantity + ", subTotal=" + subTotal + "]";
	}



}
