package com.cts.deptboot1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.deptboot1.entity.Department;
import com.cts.deptboot1.service.DepartmentService;



@RestController
@RequestMapping("/department")
public class DeptRestController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/adddept")
	public Department  saveDept(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/alldept")
	public List<Department> fetchAllDepartments(){
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/deptById/{did}")
	public Optional<Department> findDeptById(@PathVariable("did") Long did){
		return departmentService.fetchDepartmentById(did);
	}
	
}
