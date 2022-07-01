package com.cts.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.adminservice.service.OrderService;

@RestController
@RequestMapping("/admin/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("")
	public ResponseEntity<?> getOrders(@RequestParam("status") String status,@RequestParam("page") Integer pageNumber) {
		return service.getOrders(status, pageNumber);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable("orderId") Long orderId) {
		return service.getOrderDetails(orderId);
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<?> updateDeliveryStatus(@PathVariable("orderId") Long orderId, @RequestBody String status){
		return service.updateDeliveryStatus(orderId, status);
	}
}
