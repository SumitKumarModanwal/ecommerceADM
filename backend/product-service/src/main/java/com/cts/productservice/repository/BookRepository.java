package com.cts.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.productservice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("FROM Book WHERE stock>0")
	List<Book> findAllInStock();
}
