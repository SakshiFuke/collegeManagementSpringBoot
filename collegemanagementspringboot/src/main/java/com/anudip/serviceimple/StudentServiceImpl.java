package com.anudip.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Student;
import com.anudip.exception.StudentIdNotFoundException;
import com.anudip.repository.StudentRepository;
import com.anudip.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentDetails(int sid) {
		return studentRepo.findById(sid).orElseThrow(()->new StudentIdNotFoundException("Student id is not correct "));
	}

	@Override
	public Student updateStudentDetails(Student student, Integer sid) {
		Student UpdateStudent =studentRepo.findById(sid).orElseThrow(()->new StudentIdNotFoundException("Student id is not correct "));
		UpdateStudent.setSfname(student.getSfname());
		UpdateStudent.setSlname(student.getSlname());
		UpdateStudent.setSphone(student.getSphone());
		UpdateStudent.setSemail(student.getSemail());
		UpdateStudent.setSeduc(student.getSeduc());
		UpdateStudent.setSaddr(student.getSaddr());
		return studentRepo.save(UpdateStudent);
		
	}

	@Override
	public void deleteStudentDetails(int sid) {
		Student deleteStudent=studentRepo.findById(sid).orElseThrow(()->new StudentIdNotFoundException("Student id is not correct "));
		studentRepo.delete(deleteStudent);
	}

}
