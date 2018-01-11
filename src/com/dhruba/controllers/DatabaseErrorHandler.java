package com.dhruba.controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){
		return "error";
	}
	@ExceptionHandler(IOException.class)
	public String handleIOException(IOException ex){
		return "error";
	}
	@ExceptionHandler(JsonGenerationException.class)
	public String handleJsonGenerationException(JsonGenerationException ex){
		return "error";
	}
	
	@ExceptionHandler(JsonMappingException.class)
	public String handleJsonMappingException(JsonMappingException ex){
		return "error";
	}
	
}
