package com.cts.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.orderservice.OrderServiceApplication;
import com.cts.orderservice.entity.Cart;
import com.cts.orderservice.entity.CartItem;
import com.cts.orderservice.entity.Order;
import com.cts.orderservice.entity.OrderItem;
import com.cts.orderservice.entity.OrderStatus;
import com.cts.orderservice.repository.OrderItemRepository;
import com.cts.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceApplication.class);
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String CART_URL = "http://CART-SERVICE/cart";
	
	private Long sessionUserId = 16L;
	
	@Override
	public ResponseEntity<?> getAllOrdersPlaced() {
		List<Order> orderList = orderRepository.findAllByUserId(sessionUserId);
		if(orderList != null && !orderList.isEmpty()) {
			return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	@Override
	public ResponseEntity<?> getOrderByOrderId(Long orderId) {
		Order order = orderRepository.findByOrderIdAndUserId(orderId, sessionUserId);
		if(order != null) {
			List<OrderItem> orderItemList = orderItemRepository.findAllByOrderId(orderId);
			order.setBookList(orderItemList);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	@Override
	public ResponseEntity<?> placeOrder() {
		// get cart object from cart-service
		ResponseEntity<?> getCartResponse = restTemplate.getForEntity(CART_URL, Cart.class);
		if(getCartResponse.getStatusCodeValue() == 200) {
			Cart cart = (Cart)getCartResponse.getBody();
			// create order description object to generate orderId
			Order order = new Order();
			order.setUserId(sessionUserId);
			order.setTotal(cart.getTotal());
			order = orderRepository.save(order);
			// get items from cart and add into the order
			addItems(cart, order);
			// save orderItems into database
			orderItemRepository.saveAll(order.getBookList());
			// empty cart 
			restTemplate.delete(CART_URL);
			return new ResponseEntity<Order>(order, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	@Override
	public ResponseEntity<?> cancelOrder(Long orderId) {
		Order order = orderRepository.findByOrderIdAndUserId(orderId, sessionUserId);
		if(order != null) {
			order.setStatus(OrderStatus.CANCELLED.toString());
			orderRepository.save(order);
			return new ResponseEntity<Order>(order, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	private void addItems(Cart cart,Order order) {
		order.setBookList(new ArrayList<OrderItem>());
		for(CartItem cartItem: cart.getBookList()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(order.getOrderId());
			orderItem.setBook(cartItem.getBook());
			orderItem.setQuantity(cartItem.getSubTotal());
			orderItem.setSubTotal(cartItem.getSubTotal());
			order.getBookList().add(orderItem);
		}
	}
	
	
}
