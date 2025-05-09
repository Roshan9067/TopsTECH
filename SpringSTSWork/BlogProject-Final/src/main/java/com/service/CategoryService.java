package com.service;

import java.util.List;

import com.payload.CategoryDto;

public interface CategoryService {
	
	public CategoryDto addCategory(CategoryDto dto);
	public List<CategoryDto> allCategory();
	public CategoryDto categoryById(int id);
	public CategoryDto updateCategory(CategoryDto dto, int id);
	public void deleteCategory(int id);

}
