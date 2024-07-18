package com.anudip.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Department;
import com.anudip.exception.DepartmentIdNotFoundException;
import com.anudip.repository.DepartmentRepository;
import com.anudip.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public Department addDepartment(Department department) {
		return deptRepo.save(department);
	}

	@Override
	public Department getDepartmentDetails(int did) {
		return deptRepo.findById(did).orElseThrow(()->new DepartmentIdNotFoundException("Department id is not correct "));
	}

	@Override
	public Department updateDepartmentDetails(Department department, Integer did) {
		Department UpdateDepartment= deptRepo.findById(did).orElseThrow(()->new DepartmentIdNotFoundException("Department id is not correct "));
		UpdateDepartment.setDeptHOD(department.getDeptHOD());
		UpdateDepartment.setOnOfEmpl(department.getOnOfEmpl());
		return deptRepo.save(UpdateDepartment);
	}

	@Override
	public void deleteDepartmenttDetails(int did) {
		Department deleteDepartment=deptRepo.findById(did).orElseThrow(()->new DepartmentIdNotFoundException("Student id is not correct "));
		deptRepo.delete(deleteDepartment);
		
	}

}
