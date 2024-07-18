package com.anudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
