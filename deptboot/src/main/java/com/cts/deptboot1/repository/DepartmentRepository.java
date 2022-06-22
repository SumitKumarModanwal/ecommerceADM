package com.cts.deptboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.deptboot1.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>  {

}
