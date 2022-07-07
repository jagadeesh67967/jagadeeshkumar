package com.zensar.springbootDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zensar.springbootDemo.entity.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchStudentExistsException.class )
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleException(NoSuchStudentExistsException ex) {
		return new ErrorResponse(ex.getMessage());
	}

	@ExceptionHandler(value =  StudentAlreadyExistsException.class)
	@ResponseStatus
	public @ResponseBody ErrorResponse handleException(StudentAlreadyExistsException ex) {
		return new ErrorResponse(ex.getMessage());
	}
}
