package com.cts.categoryservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cts.categoryservice.entity.Category;

public interface CategoryService {
	
	ResponseEntity<?> getAllCategories();
	
	ResponseEntity<?> getCategoryById(Long categoryId);
}
