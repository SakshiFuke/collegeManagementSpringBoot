package com.anudip.service;

import com.anudip.entity.Courses;

public interface CoursesService {

	Courses addCourses(Courses courses);
	
	Courses getCoursesDetails(int cid);
	
	Courses updateCourses(Courses courses,Integer cid);
	
	void deleteCoursesDetails(int cid);
}
