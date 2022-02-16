package com.greeting.config;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.greeting.exception.EmptyListException;
import com.greeting.responsedto.ResponseDTO;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseDTO<String>> greetingAlreadyExisted(SQLIntegrityConstraintViolationException greetingException){
		ResponseDTO<String> response = new ResponseDTO<String>("the type of the greeting already existed in the DB",
				greetingException.getMessage());
		return new ResponseEntity<ResponseDTO<String>>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ResponseDTO<String>> emtpyListException(EmptyListException greetingException){
		ResponseDTO<String> response = new ResponseDTO<String>("empty list",
				greetingException.getMessage());
		return new ResponseEntity<ResponseDTO<String>>(response, HttpStatus.OK);
	}
}
