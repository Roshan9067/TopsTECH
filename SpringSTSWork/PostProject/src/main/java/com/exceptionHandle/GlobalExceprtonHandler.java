package com.exceptionHandle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.Dto.APIResponse;

public class GlobalExceprtonHandler {
	
	public ResponseEntity<APIResponse> ResourceNotFountException(ResourceNotFoundException e){
		
		String message = e.getMessage();
		String success = "false";
		APIResponse response = new APIResponse(message,success);
		
		return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		
		Map<String, String> map = new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach((err)->{
			
			String fieldname = ((FieldError)err).getField();
			String message = err.getDefaultMessage();
			
			map.put(fieldname, message);
			
			
		});
		
		
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
	}
		


}
