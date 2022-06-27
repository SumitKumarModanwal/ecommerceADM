package com.cts.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.adminservice.AdminServiceApplication;
import com.cts.adminservice.entity.Order;
import com.cts.adminservice.repository.OrderItemRepository;
import com.cts.adminservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceApplication.class);

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Override
	public ResponseEntity<?> getAllUndeliveredOrders() {
		List<Order> orderList = orderRepository.findAllUndeliveredOrders();
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> getOrderDetails(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		
		if(!order.isEmpty()) {
			order.get().setBookList(orderItemRepository.findOrderItemByOrderId(orderId));
			LOGGER.error(order.get().toString());
			return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<?> updateDeliveryStatus(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if(!order.isEmpty()) {
			order.get().setDelivered(true);
			orderRepository.save(order.get());
			return new ResponseEntity( HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
}
