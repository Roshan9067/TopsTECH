package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repo.CategoryRepo;
import com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo repo;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public List<Category> viewAllCategory() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category updateCategory(Category category, int id) {
		// TODO Auto-generated method stub
		category.setId(id);
		return repo.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public Category categoryById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

}
