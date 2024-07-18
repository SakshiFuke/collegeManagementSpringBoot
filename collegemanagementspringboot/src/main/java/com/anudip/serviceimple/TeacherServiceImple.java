package com.anudip.serviceimple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.dto.TeacherDTO;
import com.anudip.entity.Teacher;
import com.anudip.exception.TeacherIdNotFoundException;
import com.anudip.repository.TeacherRepository;
import com.anudip.service.TeacherService;
import com.anudip.util.TeacherConverter;

@Service
public class TeacherServiceImple implements TeacherService {

	@Autowired
	TeacherRepository teacherRepo;
	
	@Autowired
	TeacherConverter tcover;
	@Override
	public TeacherDTO addTeacher(Teacher teacher) {
		return tcover.ConvertTeacherToTeacherDTO(teacher);
	}

	//use findById of
	@Override
	public Teacher getTeacherDetails(int tid) {
		return teacherRepo.findById(tid).orElseThrow(()->new TeacherIdNotFoundException("Teacher id is not correct"));	
	}

	@Override
	public Teacher updateTeacherDetails(Teacher teacher, int tid) {
		Teacher UpdateTeacher=teacherRepo.findById(tid).orElseThrow(()-> new TeacherIdNotFoundException("Teacher  "));
		//set new values
		UpdateTeacher.setTphone(teacher.getTphone());
		UpdateTeacher.setDesignation(teacher.getDesignation());
		return teacherRepo.save(UpdateTeacher);
		 
	}

	@Override
	public void deleteTeacherDetails(int tid) {
		Teacher delTeacher=teacherRepo.findById(tid).orElseThrow(()-> new TeacherIdNotFoundException("Teacher Id not found"));
		teacherRepo.delete(delTeacher);
		
	}

	@Override
	public Teacher getTeacherByPhone(long tphone) {
		return teacherRepo.findTeacherByPhone(tphone);
	}

	@Override
	public List<Teacher> getTeachersdesignation(String designation) {
		return teacherRepo.findTeacherDesignation(designation);
	}

	@Override
	public List<Teacher> getTeachername(String tname) {
		return teacherRepo.FindTecherName(tname);
	}

}
