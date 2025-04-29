package com.example.tripplanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	 String resourceName;
	 String propertyName;
	 int propertyValue;
	public ResourceNotFound(String resourceName, String propertyName, int propertyValue) {
		super();
		this.resourceName = resourceName;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return resourceName+" "+propertyName+" "+propertyValue+"Not Found";
	}
	
	 
}

