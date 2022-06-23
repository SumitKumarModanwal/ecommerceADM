package com.cts.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cartservice.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {

}
