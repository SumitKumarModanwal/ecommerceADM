package com.cts.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	
	@Autowired
	private OrderService service;
	
	@GetMapping("")
	public ResponseEntity<?> getAllOrdersPlaced(){
		return service.getAllOrdersPlaced();
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderByOrderId(@PathVariable("orderId") Long orderId){
		return service.getOrderByOrderId(orderId);
	}
	
	@PostMapping("")
	public ResponseEntity<?> placeOrder(){
		return service.placeOrder();
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> cancelOrder(@PathVariable Long orderId){
		return service.cancelOrder(orderId);
	}
	
	
}
