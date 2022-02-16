package com.userservice.exception;

import java.util.NoSuchElementException;

public class NotFoundException extends NoSuchElementException{


	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}
}
