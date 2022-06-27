package com.cts.orderservice.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "OrderDescription")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@Column(nullable = true)
	@JsonIgnore
	private Long userId;
	private Timestamp orderDate;
	@Transient
	@JsonInclude
	private List<OrderItem> bookList;
	private boolean isDelivered;
	private boolean isCancelled;
	private Integer total;
	
	public Order() {
		this.orderDate = new Timestamp(System.currentTimeMillis());
		this.isDelivered = false;
		this.isCancelled = false;
	}
	

	public Order(Long orderId, Long userId, Timestamp orderDate, List<OrderItem> bookList, boolean isDelivered,
			boolean isCancelled, Integer total) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.bookList = bookList;
		this.isDelivered = isDelivered;
		this.isCancelled = isCancelled;
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

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", bookList="
				+ bookList + ", isDelivered=" + isDelivered + ", isCancelled=" + isCancelled + ", total=" + total + "]";
	}
	

}
