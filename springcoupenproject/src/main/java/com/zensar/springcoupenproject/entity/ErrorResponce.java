package com.zensar.springcoupenproject.entity;

public class ErrorResponce {
	
	 private int statusCode;
	 private String message;
	public ErrorResponce( String message) {
		super();
		this.message = message;
	}
	public ErrorResponce(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}

}
