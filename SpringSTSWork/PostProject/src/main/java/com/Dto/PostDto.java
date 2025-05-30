package com.Dto;




import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostDto{
	private int id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private String img;
	private UserDto user;
	private CategoryDto category;
	
	
	

}
