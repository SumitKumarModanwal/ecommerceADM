package com.cts.categoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.categoryservice.entity.Category;
import com.cts.categoryservice.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategoryById(@PathVariable("categoryId") Long categoryId){
		return categoryService.getCategoryById(categoryId);
	}
}