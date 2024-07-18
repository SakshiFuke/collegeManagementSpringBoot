package com.anudip.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class TeacherDTO {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	
//	@Column(length = 25,nullable = false)
	//@NotBlank(message = "Teacher name can not be blank")//validation 
	private String tname;
	
	//@Column(length = 25, nullable = false)
	//@NotBlank(message = "Teacher surname can not be blank")//validation 
	private String tsurname;
	
	//@Column(length = 25,nullable = false,unique = true)
	//@NotBlank(message = "Teacher Email Id can not be blank")//validation 
	//@Email(message = "Email id is not proper")
	private String temail;
	
	//@Column(length = 25,nullable = false, unique = true)
	//@NotNull(message = "phone number can not be null")
	private String tphone;
	
//	@Column(length = 25)
	//@NotBlank(message = "Dessignation cannot be blank")
	private String designation;
}
