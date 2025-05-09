package com.service;

import java.util.List;

import com.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public List<Category> viewAllCategory();
	public Category updateCategory(Category category,int id);
	public void deleteCategory(int id);
	public Category categoryById(int id);

}

