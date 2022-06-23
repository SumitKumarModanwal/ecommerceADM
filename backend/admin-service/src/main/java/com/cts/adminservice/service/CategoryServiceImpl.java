package com.cts.adminservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.adminservice.AdminServiceApplication;
import com.cts.adminservice.entity.Category;
import com.cts.adminservice.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceApplication.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<?> addCategory(Category category) {
		categoryRepository.save(category);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> updateCategory(Long categoryId, Category category) {
		Optional<Category> searchedCategory = categoryRepository.findById(categoryId);
		if (!searchedCategory.isEmpty() && searchedCategory.get() != null) {
			categoryRepository.save(category);
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> deleteCategory(Long categoryId) {
		Optional<Category> searchedCategory = categoryRepository.findById(categoryId);
		LOGGER.warn(searchedCategory.get().toString());
		if (!searchedCategory.isEmpty() && searchedCategory.get() != null) {
			categoryRepository.deleteById(categoryId);
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
