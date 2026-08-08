package com.suti.product.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	
	
}
