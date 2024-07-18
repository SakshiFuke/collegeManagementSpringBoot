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

import com.anudip.entity.Student;
import com.anudip.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	StudentService sservice;
	
	@PostMapping("/Student/addStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student)
	{
		return new ResponseEntity<Student>(sservice.addStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/Student/get/{sid}")
	public ResponseEntity<Student> getStudent(@PathVariable("sid") int sid)
	{
		return new ResponseEntity<Student>(sservice.getStudentDetails(sid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Student/remove/{sid}")
	public ResponseEntity<String> deleteStudent(@PathVariable("sid") int sid)
	{
		return new ResponseEntity<String>("Delete successfully...",HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
		@PutMapping("/Student/update/{sid}")
		public ResponseEntity<Student> editStudent(@PathVariable("sid") Integer sid, @Valid @RequestBody Student student)
		{
			Student updateStudent=sservice.updateStudentDetails(student , sid);
			return new ResponseEntity<Student>(updateStudent , HttpStatus.OK); 
		}
}
