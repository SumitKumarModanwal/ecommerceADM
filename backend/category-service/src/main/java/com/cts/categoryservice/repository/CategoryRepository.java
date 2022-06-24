package com.cts.categoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.categoryservice.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
