package com.zensar.springbootDemo.exceptions;

public class StudentAlreadyExistsException extends RuntimeException{
	
	private String message;

	public StudentAlreadyExistsException() {
		super();
		
	}

	public StudentAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
	
}
