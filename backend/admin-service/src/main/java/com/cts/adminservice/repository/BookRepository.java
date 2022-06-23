package com.cts.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.adminservice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
