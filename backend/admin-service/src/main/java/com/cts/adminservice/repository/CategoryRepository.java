package com.cts.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.adminservice.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
