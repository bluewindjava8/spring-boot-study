package com.bluewind.errorhandling.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bluewind.errorhandling.exception.BookNotFoundException;

@ControllerAdvice
public class BookErrorHandler{

	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<Object> exception(BookNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
