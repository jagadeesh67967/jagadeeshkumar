package com.zensar.springcoupenproject.exception;

public class CoupenExistsException extends RuntimeException{
	
	private String message;

	public CoupenExistsException() {
		super();
		
	}

	public  CoupenExistsException(String message) {
		super(message);
		this.message = message;
	}

}
