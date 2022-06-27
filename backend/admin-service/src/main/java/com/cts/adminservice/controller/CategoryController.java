package com.cts.adminservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.adminservice.AdminServiceApplication;
import com.cts.adminservice.entity.Category;
import com.cts.adminservice.service.CategoryService;

@RestController
@RequestMapping("/admin/categories")
public class CategoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceApplication.class);
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		LOGGER.warn(category.toString());
		return categoryService.addCategory(category);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody Category category) {
		return categoryService.updateCategory(category.getCategoryId(), category);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> removeCategory(@PathVariable("categoryId") Long categoryId){
		return categoryService.deleteCategory(categoryId);
	}
}
