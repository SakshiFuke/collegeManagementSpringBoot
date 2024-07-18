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

import com.anudip.entity.Courses;
import com.anudip.service.CoursesService;

import jakarta.validation.Valid;

@RestController
public class CoursesController {

	@Autowired
	CoursesService cservice;
	
	@PostMapping("/Courses/addCourses")
	public ResponseEntity<Courses> saveCourses(@Valid @RequestBody Courses courses)
	{
		return new ResponseEntity<Courses>(cservice.addCourses(courses),HttpStatus.CREATED);
	}
	
	@GetMapping("/Courses/get/{cid}")
	public ResponseEntity<Courses> getCourses(@PathVariable("cid") int cid)
	{
		return new ResponseEntity<Courses>(cservice.getCoursesDetails(cid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Courses/remove/{cid}")
	public ResponseEntity<String> deleteCourses(@PathVariable("cid") int cid)
	{
		return new ResponseEntity<String>("Delete successfully...",HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
		@PutMapping("/Courses/update/{cid}")
		public ResponseEntity<Courses> editCourses(@PathVariable("cid") Integer cid, @Valid @RequestBody Courses courses)
		{
			Courses updateCourses=cservice.updateCourses(courses , cid);
			return new ResponseEntity<Courses>(updateCourses , HttpStatus.OK); 
		}
}
