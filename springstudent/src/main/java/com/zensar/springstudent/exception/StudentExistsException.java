package com.zensar.springstudent.exception;

public class StudentExistsException extends RuntimeException{
	
	private String message;

	public StudentExistsException() {
		super();
		
	}

	public  StudentExistsException(String message) {
		super(message);
		this.message = message;
	}

}
