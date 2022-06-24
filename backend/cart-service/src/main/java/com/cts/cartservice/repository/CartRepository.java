package com.cts.cartservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.cartservice.entity.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

	@Query(value = "SELECT * FROM Cart WHERE book_id=?1 AND user_id=?2", nativeQuery = true)
	CartItem findByBookIdAndUserId(Long bookId, Long userId);
	
	@Query(value = "SELECT * FROM Cart WHERE user_id=?", nativeQuery = true)
	List<CartItem> findByUserId(Long userId);
}
