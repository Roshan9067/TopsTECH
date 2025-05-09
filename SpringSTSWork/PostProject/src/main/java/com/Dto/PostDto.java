package com.Dto;




import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto{
	private int id;
	private String title;
	private String content;
	private String img;
	private UserDto user;
	private CategoryDto category;
	
	
	

}
