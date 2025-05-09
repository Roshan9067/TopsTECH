package com.exception;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		
		String message = e.getMessage();
		String success = "false";
		APIResponse response = new APIResponse(message,success);
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(exception =  MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler( MethodArgumentNotValidException ex) {
		
		Map<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((err)->{
			
			String fieldName = ((FieldError)err).getField();
			String message = err.getDefaultMessage();
			
			map.put(fieldName, message);
			
			
		});
		
		return new ResponseEntity<Map<String, String>>(map,HttpStatus.BAD_REQUEST);
		
	}

}
