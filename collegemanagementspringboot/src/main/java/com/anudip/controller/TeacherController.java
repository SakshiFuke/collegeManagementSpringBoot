package com.anudip.controller;

import java.util.List;

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

import com.anudip.dto.TeacherDTO;
import com.anudip.entity.Teacher;
import com.anudip.service.TeacherService;
import com.anudip.util.TeacherConverter;

import jakarta.validation.Valid;

@RestController //@Controller+@Request Body 
public class TeacherController {

	@Autowired
	TeacherService tservice;
	
	@Autowired
	TeacherConverter tconvert;
	//postman
//	@PostMapping("/Teacher/addTeacher")
//	public ResponseEntity<Teacher> saveTeacher(@Valid @RequestBody Teacher teacher)
//	{
//		return new ResponseEntity<Teacher>(tservice.addTeacher(teacher),HttpStatus.CREATED);
//	}
	
	@PostMapping("/Teacher/addTeacher")
	public ResponseEntity<TeacherDTO> saveTeacher(@Valid @RequestBody TeacherDTO tdto)
	{
		Teacher teacher=tconvert.ConvertTeacherDTOToTeacher(tdto);
		return new ResponseEntity<TeacherDTO>(tservice.addTeacher(teacher),HttpStatus.CREATED);
	}
	
	//
	@GetMapping("/Teacher/get/{tid}")
	public ResponseEntity<Teacher> getTeacher (@PathVariable("tid") int tid)
	{
		return new ResponseEntity<Teacher>(tservice.getTeacherDetails(tid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Teacher/remove/{tid}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("tid") int tid)
	{
		return new ResponseEntity<String>("Delete successfully..",HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
	@PutMapping("/Teacher/update/{tid}")
	public ResponseEntity<Teacher> editTeacher(@PathVariable("tid") int tid, @Valid @RequestBody Teacher teacher)
	{
		return new ResponseEntity<>(tservice.updateTeacherDetails(teacher, tid) ,HttpStatus.OK);
	}
	
	@GetMapping("Teacher/getTeacherName/{tname}")
	public List<Teacher> getTeacherName(@PathVariable("tname") String tname)
	{
		return tservice.getTeachername(tname);
	}
	
	@GetMapping("Teacher/getTeacherPhone/{tphone}")
	public ResponseEntity<Teacher> getTeacherPhone(@PathVariable("tphone") long tphone)
	{
		return new ResponseEntity<>(tservice.getTeacherByPhone(tphone) ,HttpStatus.OK);
	}
	
	@GetMapping("Teacher/getTeacherDesignation/{designation}")
	public List<Teacher> getTeacherDesignation(@PathVariable("designation") String designation)
	{
		return tservice.getTeachersdesignation(designation);
	}
}













