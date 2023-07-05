package com.manulogix.springweb.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manulogix.springweb.controller.Entity.ErrorMessage;

/**
 * This class is used to intercept the error message from the API (Ex: getDepartmentById) and 
 * filter the exception to pass on just the exception message instead of the entire stack track
 * @ControllerAdvice can be setup on base package to encompass all controllers & RequestMappings
 * 
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	/*
	 * create a method that will be responsible to handle the exception for DepartmentNotFoundException
	 */
	
	@ExceptionHandler(DepartmentNotFoundExcception.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException (DepartmentNotFoundExcception ex, 
													 WebRequest request)
	{
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(error.getStatus()).body(error);

	}
	
}
