package com.cts.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.adminservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query(value = "SELECT * FROM order_description LIMIT 10 OFFSET ?", nativeQuery = true)
	List<Order> findOrders(Integer pageNumber);

	@Query(value = "SELECT * FROM order_description WHERE status=?1 LIMIT 10 OFFSET ?2", nativeQuery = true)
	List<Order> findOrdersByStatus(String status, Integer pageNumber);
}
