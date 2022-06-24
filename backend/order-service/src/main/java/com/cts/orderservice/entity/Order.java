package com.cts.orderservice.entity;

import java.sql.Timestamp;
import java.util.List;

public class Order {
	
	private Long orderId;
	private Long userId;
	private Timestamp orderDate;
	private List<OrderItem> bookList;
	private boolean isDelivered;
	private Integer total;
	
	public Order() {
		
	}
	
	public Order(Long orderId, Long userId, Timestamp orderDate, List<OrderItem> bookList, boolean isDelivered,
			Integer total) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.bookList = bookList;
		this.isDelivered = isDelivered;
		this.total = total;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getBookList() {
		return bookList;
	}

	public void setBookList(List<OrderItem> bookList) {
		this.bookList = bookList;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", bookList="
				+ bookList + ", isDelivered=" + isDelivered + ", total=" + total + "]";
	}
	

}
