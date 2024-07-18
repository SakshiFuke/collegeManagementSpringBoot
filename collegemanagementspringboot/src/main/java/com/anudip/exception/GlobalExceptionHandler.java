package com.anudip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(TeacherIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleTeacherException(TeacherIdNotFoundException tx, WebRequest request) 
	{
		ErrorMessage er=new ErrorMessage(HttpStatus.NOT_FOUND,tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	
	@ExceptionHandler(StudentIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleStudentException(StudentIdNotFoundException tx, WebRequest request) 
	{
		ErrorMessage er=new ErrorMessage(HttpStatus.NOT_FOUND,tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	
	@ExceptionHandler(DepartmentIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleDepartmentException(DepartmentIdNotFoundException tx, WebRequest request) 
	{
		ErrorMessage er=new ErrorMessage(HttpStatus.NOT_FOUND,tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	
	@ExceptionHandler(CoursesIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCoursesException(CoursesIdNotFoundException tx, WebRequest request) 
	{
		ErrorMessage er=new ErrorMessage(HttpStatus.NOT_FOUND,tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	
	@ExceptionHandler(BatchIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBatchesException(BatchIdNotFoundException tx, WebRequest request) 
	{
		ErrorMessage er=new ErrorMessage(HttpStatus.NOT_FOUND,tx.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
}