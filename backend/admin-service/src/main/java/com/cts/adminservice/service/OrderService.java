package com.cts.adminservice.service;

import org.springframework.http.ResponseEntity;

public interface OrderService {

	ResponseEntity<?> getAllUndeliveredOrders();

	ResponseEntity<?> getOrderDetails(Long orderId);
	
	ResponseEntity<?> updateDeliveryStatus(Long orderId, String orderStatus);

}
