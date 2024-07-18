package com.anudip.service;

import com.anudip.entity.Student;

public interface StudentService {

	Student addStudent(Student student);
	
	Student getStudentDetails(int sid);
	
	Student updateStudentDetails(Student student,Integer sid);
	
	void deleteStudentDetails(int sid);
}