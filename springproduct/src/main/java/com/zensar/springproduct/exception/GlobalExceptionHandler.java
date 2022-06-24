package com.zensar.springproduct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zensar.springproduct.entity.ErrorResponce;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NoSuchProductExistsException.class )
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleException(NoSuchProductExistsException ex) {
		return new ErrorResponce(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value =  ProductExistsException.class)
	@ResponseStatus
	public @ResponseBody ErrorResponce handleException(ProductExistsException ex) {
		return new ErrorResponce(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

}
