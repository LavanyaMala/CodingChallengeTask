package com.task.exception;

public class DBOperationFailedException extends Exception{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DBOperationFailedException(String message) {
		super();
		this.message = message;
	}
	
	    
	}


