package com.cts.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.adminservice.service.OrderService;

@RestController
@RequestMapping("/admin/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("")
	public ResponseEntity<?> getAllUndeliveredOrders() {
		return service.getAllUndeliveredOrders();
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable("orderId") Long orderId) {
		return service.getOrderDetails(orderId);
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<?> updateDeliveryStatus(@PathVariable("orderId") Long orderId){
		return service.updateDeliveryStatus(orderId);
	}
}
