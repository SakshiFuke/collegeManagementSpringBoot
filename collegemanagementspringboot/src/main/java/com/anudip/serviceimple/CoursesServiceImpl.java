package com.anudip.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Courses;
import com.anudip.exception.CoursesIdNotFoundException;
import com.anudip.repository.CoursesRepository;
import com.anudip.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService{

	@Autowired
	CoursesRepository coursesRepo;
	
	@Override
	public Courses addCourses(Courses courses) {
		return coursesRepo.save(courses);
	}

	@Override
	public Courses getCoursesDetails(int cid) {
		return coursesRepo.findById(cid).orElseThrow(()-> new CoursesIdNotFoundException("Course Id is Not correct "));
	}

	@Override
	public Courses updateCourses(Courses courses, Integer cid) {
		Courses UpdateCourses= coursesRepo.findById(cid).orElseThrow(()-> new CoursesIdNotFoundException("Course Id is Not correct "));
		UpdateCourses.setDuration(courses.getDuration());
		UpdateCourses.setCourseFees(courses.getCourseFees());
		return coursesRepo.save(UpdateCourses);
	}

	@Override
	public void deleteCoursesDetails(int cid) {
		Courses deleteCourses=coursesRepo.findById(cid).orElseThrow(()->new CoursesIdNotFoundException("Student id is not correct "));
		coursesRepo.delete(deleteCourses);
	}

}
