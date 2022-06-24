package com.cts.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.adminservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query(value = "SELECT * FROM order_description WHERE is_delivered=0 AND is_cancelled=0", nativeQuery = true)
	List<Order> findAllUndeliveredOrders();
}
