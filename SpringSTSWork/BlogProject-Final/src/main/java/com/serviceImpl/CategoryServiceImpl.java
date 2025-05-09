package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Category;
import com.payload.CategoryDto;
import com.repo.CategoryRepo;
import com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo repo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public CategoryDto addCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		
		Category category = mapper.map(dto, Category.class); 
		Category addCategory = repo.save(category);
		CategoryDto categoryDto = mapper.map(addCategory,CategoryDto.class);
		return categoryDto;
		
	}

	@Override
	public List<CategoryDto> allCategory() {
		// TODO Auto-generated method stub
		List<Category> allCategory = repo.findAll();
		List<CategoryDto> dto = allCategory.stream().map(cat->mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public CategoryDto categoryById(int id) {
		// TODO Auto-generated method stub
		Category category = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto dto, int id) {
		// TODO Auto-generated method stub
		Category category = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
		category.setTitle(dto.getTitle());
		Category updateCategory = repo.save(category);
		
		return mapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Category category = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
		repo.delete(category);
		
	}

}
