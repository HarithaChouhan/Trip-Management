package com.example.tripplanner.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationHandler {
	@ExceptionHandler(ResourceNotFound.class)
	public Map<String, String> handlemethod(ResourceNotFound ex){

		Map<String,String> errors=new HashMap<>();
		
			errors.put("errorMessage", ex.getMessage());
			
		
		return errors;
	}
}
