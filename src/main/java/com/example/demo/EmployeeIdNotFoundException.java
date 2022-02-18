package com.example.demo;

public class EmployeeIdNotFoundException extends RuntimeException{

	private String message;

	

	public EmployeeIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
