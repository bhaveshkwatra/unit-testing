package com.nagarro.nagp.assignment.unit.testing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = -2256037190847514677L;

	public ResourceNotFoundException(String message){
    	super(message);
    }
}
