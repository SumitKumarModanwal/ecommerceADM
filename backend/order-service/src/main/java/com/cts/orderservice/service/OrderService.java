package com.cts.orderservice.service;

import org.springframework.http.ResponseEntity;


public interface OrderService {
	ResponseEntity<?> getAllOrdersPlaced();
	
	ResponseEntity<?> getOrderByOrderId(Long orderId);
	
	ResponseEntity<?> placeOrder();
	
	ResponseEntity<?> cancelOrder(Long orderId);
}
