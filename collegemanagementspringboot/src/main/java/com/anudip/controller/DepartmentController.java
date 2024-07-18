package com.anudip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.entity.Department;
import com.anudip.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService dservice;
	
	@PostMapping("/Department/addDepartment")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department)
	{
		return new ResponseEntity<Department>(dservice.addDepartment(department),HttpStatus.CREATED);
	}
	
	@GetMapping("/Department/get/{did}")
	public ResponseEntity<Department> getDepartment(@PathVariable("did") int did)
	{
		return new ResponseEntity<Department>(dservice.getDepartmentDetails(did),HttpStatus.OK);
	}
	
	@DeleteMapping("/Department/remove/{did}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("did") int did)
	{
		return new ResponseEntity<String>("Delete successfully...",HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
		@PutMapping("/Department/update/{did}")
		public ResponseEntity<Department> editDepartment(@PathVariable("did") Integer did, @Valid @RequestBody Department department)
		{
			Department updateDepartment=dservice.updateDepartmentDetails(department , did);
			return new ResponseEntity<Department>(updateDepartment , HttpStatus.OK); 
		}
}
