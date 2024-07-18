package com.anudip.util;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

import com.anudip.dto.TeacherDTO;
import com.anudip.entity.Teacher;
//this class will be responsible to convert from DTO to entity and vice versa

//instead of teacher entity we are using teacher dto
@Component
public class TeacherConverter {

	public Teacher ConvertTeacherDTOToTeacher(TeacherDTO tdto)
	{
		Teacher tc=new Teacher();
		if(tdto!=null)
		{
		BeanUtils.copyProperties(tdto, tc);
		}
		return tc;
		
	}
	public TeacherDTO ConvertTeacherToTeacherDTO(Teacher teacher)
	{
		TeacherDTO tdto=new TeacherDTO();
		if(teacher!=null)
		{
			BeanUtils.copyProperties(teacher,tdto);
		}
		return tdto;
	}
}
