package com.cts.adminservice.service;

import org.springframework.http.ResponseEntity;

import com.cts.adminservice.entity.Category;

public interface CategoryService {
	
	ResponseEntity<?> addCategory(Category category);
	
	ResponseEntity<?> updateCategory(Long categoryId, Category category);
	
	ResponseEntity<?> deleteCategory(Long categoryId);
}
