package com.cts.categoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.categoryservice.entity.Category;
import com.cts.categoryservice.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ResponseEntity<?> getAllCategories() {
		List<Category> categoryList = categoryRepository.findAll();
		if(!categoryList.isEmpty()) {
			return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> getCategoryById(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(!category.isEmpty() && category.get() != null) {
			return new ResponseEntity<Category>(category.get(), HttpStatus.OK);
			
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
