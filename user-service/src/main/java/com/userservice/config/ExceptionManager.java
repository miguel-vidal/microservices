package com.userservice.config;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.userservice.exception.EmptyListException;
import com.userservice.exception.NotFoundException;
import com.userservice.exception.NullException;
import com.userservice.responsedto.ResponseDTO;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseDTO<String>> greetingAlreadyExisted(SQLIntegrityConstraintViolationException greetingException){
		ResponseDTO<String> response = new ResponseDTO<String>("the name of the user already existed in the DB",
				greetingException.getMessage());
		return new ResponseEntity<ResponseDTO<String>>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ResponseDTO<String>> notFoundException(NotFoundException notFound){
		ResponseDTO<String> response = new ResponseDTO<String>("the element doesnt exist in the DB", notFound.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NullException.class)
	public ResponseEntity<ResponseDTO<String>> notFoundException(NullException notFound){
		ResponseDTO<String> response = new ResponseDTO<String>("the element doesnt exist in the DB", notFound.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ResponseDTO<String>> notFoundException(EmptyListException notFound){
		ResponseDTO<String> response = new ResponseDTO<String>("the list is empty", notFound.getMessage());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
