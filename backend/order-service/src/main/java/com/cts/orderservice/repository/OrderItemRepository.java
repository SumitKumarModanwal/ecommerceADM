package com.cts.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.orderservice.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	@Query(value = "SELECT * FROM order_item WHERE order_id=?", nativeQuery = true)
	List<OrderItem> findAllByOrderId(Long orderId);
}
