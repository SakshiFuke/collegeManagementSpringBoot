package com.anudip.service;

import com.anudip.entity.Department;

public interface DepartmentService {

	Department addDepartment(Department department);
	
	Department getDepartmentDetails(int did);
	
	Department updateDepartmentDetails(Department department,Integer did);
	
	void deleteDepartmenttDetails(int sid);
}
