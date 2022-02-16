package com.userservice.exception;

public class NullException extends NullPointerException{
	
	private static final long serialVersionUID = 1L;

	public NullException(String message) {
		super(message);
	}

}
