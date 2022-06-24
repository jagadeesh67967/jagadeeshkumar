package com.zensar.springcoupenproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zensar.springcoupenproject.entity.ErrorResponce;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NoSuchCoupenExistsException.class )
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponce handleException(NoSuchCoupenExistsException ex) {
		return new ErrorResponce(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value =  CoupenExistsException.class)
	@ResponseStatus
	public @ResponseBody ErrorResponce handleException(CoupenExistsException ex) {
		return new ErrorResponce(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

}
