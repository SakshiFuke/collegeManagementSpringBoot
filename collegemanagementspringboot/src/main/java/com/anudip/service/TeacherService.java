package com.anudip.service;

import java.util.List;

import com.anudip.dto.TeacherDTO;
import com.anudip.entity.Teacher;

public interface TeacherService {

	//method for saving teacher details in db table
	TeacherDTO addTeacher(Teacher teacher);
	
	//method to fetch teacher details based on tid from db table
	Teacher getTeacherDetails(int tid);
	
	//method to modify teacher details based on tid from db table
	Teacher updateTeacherDetails(Teacher teacher,int tid);
	
	//method to remove teacher details on tid from db table
	void deleteTeacherDetails(int tid);
	
	//method to fetch teacher details based on phone number 
	Teacher getTeacherByPhone(long tphone);
	
	//method to fetch teacher details based on first letter of teacher
	List<Teacher> getTeachersdesignation(String designation);
	
	List<Teacher> getTeachername(String tname);
}
