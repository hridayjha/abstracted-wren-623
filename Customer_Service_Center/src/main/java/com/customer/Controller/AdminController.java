package com.customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.customer.Entity.Department;
import com.customer.Exception.DepartmentException;
import com.customer.Service.AdminService;

import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/dept")
	public ResponseEntity<Department>addDept(@Valid @RequestBody Department d)
	{
		Department dept=adminService.addDepartment(d);
		return new ResponseEntity<>(dept,HttpStatus.CREATED);
	}
	@PutMapping("/dept")
	public ResponseEntity<Department>updDept(@Valid @RequestBody Department d) throws DepartmentException
	{
		Department dept=adminService.updateDepartment(d);
		return new ResponseEntity<>(dept,HttpStatus.OK);
	}
}
