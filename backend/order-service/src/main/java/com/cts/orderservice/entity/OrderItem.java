package com.cts.orderservice.entity;



public class OrderItem {
	
	private Long orderItemId;
	private Book book;
	private Integer quantity;
	private Integer total;
	
	public OrderItem() {}
	
	public OrderItem(Long orderItemId, Book book, Integer quantity, Integer total) {
		super();
		this.orderItemId = orderItemId;
		this.book = book;
		this.quantity = quantity;
		this.total = total;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", book=" + book + ", quantity=" + quantity + ", total="
				+ total + "]";
	}
	
	
	
}
