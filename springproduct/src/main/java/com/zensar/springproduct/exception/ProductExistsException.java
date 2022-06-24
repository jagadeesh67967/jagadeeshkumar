package com.zensar.springproduct.exception;

public class ProductExistsException extends RuntimeException{
	
	private String message;

	public ProductExistsException() {
		super();
		
	}

	public  ProductExistsException(String message) {
		super(message);
		this.message = message;
	}

}
