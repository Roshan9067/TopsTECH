package com.exceptionHandle;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	int id;
	
	public ResourceNotFoundException(String resourceName,String fieldName,int id) {
		
		super(String.format("%s with %s : %s is not found",resourceName,fieldName,id));
		this.fieldName=resourceName;
		this.fieldName=fieldName;
		this.id=id;
		
	}
}
