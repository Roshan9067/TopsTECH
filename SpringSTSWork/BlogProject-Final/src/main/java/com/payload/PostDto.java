package com.payload;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	private int id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private String image;
    CategoryDto category;
	UserDto user;
	
	
	

}
