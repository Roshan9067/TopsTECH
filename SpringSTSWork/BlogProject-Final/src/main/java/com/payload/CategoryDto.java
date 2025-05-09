package com.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {
	
	private int id;
	
	@NotBlank
	private String title;
	
}
