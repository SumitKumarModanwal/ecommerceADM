package com.cts.adminservice.service;

import org.springframework.http.ResponseEntity;

public interface OrderService {

	ResponseEntity<?> getOrders(String status, Integer pageNumber);

	ResponseEntity<?> getOrderDetails(Long orderId);
	
	ResponseEntity<?> updateDeliveryStatus(Long orderId, String orderStatus);

}
