package com.zensar.springstudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zensar.springstudent.entity.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(value = NoSuchStudentExistsException.class )
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleException(NoSuchStudentExistsException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value =  StudentExistsException.class)
	@ResponseStatus
	public @ResponseBody ErrorResponse handleException(StudentExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
}
