package com.zensar.springcoupenproject.exception;

public class NoSuchCoupenExistsException extends RuntimeException{
	
	private String message;

	public NoSuchCoupenExistsException() {
		super();
		
	}

	public NoSuchCoupenExistsException(String message) {
		super(message);
		this.message = message;
	}

}
