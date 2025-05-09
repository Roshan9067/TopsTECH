package com.service;

import java.util.List;

import com.Dto.CategoryDto;

public interface CategoryService {
	
	public CategoryDto addCategory(CategoryDto categoryDto);
	public List<CategoryDto> allCategory();
	public CategoryDto updateCategory(CategoryDto categoryDto,int id);
	public CategoryDto categoryById(int id);
	public void deleteCategory(int id);
	

}
