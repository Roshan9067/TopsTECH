package com.exceptionHandle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GlobalExceprtonHandler {
	
	public ResponseEntity MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		
		Map<String, String> map = new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach((err)->{
			
			
		});
		
		
		
		return null;
		
	}
		


}
