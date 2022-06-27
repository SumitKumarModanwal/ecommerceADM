package com.cts.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.orderservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "SELECT * FROM order_description WHERE user_id=?", nativeQuery = true)
	List<Order> findAllByUserId(Long userId);
	
	@Query(value = "SELECT * FROM order_description WHERE order_id=?1 AND user_id=?2", nativeQuery = true)
	Order findByOrderIdAndUserId(Long orderId, Long userId);
}
