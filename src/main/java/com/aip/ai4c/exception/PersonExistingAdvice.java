package com.aip.ai4c.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PersonExistingAdvice {
	
	@ResponseBody
	@ExceptionHandler(PersonExisitingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String personExistingHandler(PersonExisitingException pe) {
		return pe.getMessage();
	}
	
}
