package com.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	int id;
	
	public ResourceNotFoundException(String resourceName,String fieldName,int id) {
		super(String.format("%s with %s : %s is not found",fieldName, fieldName,id));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.id=id;
	}

}
