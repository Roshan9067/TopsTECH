package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.CategoryDto;
import com.model.Category;
import com.repo.CategoryRepo;
import com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category create = mapper.map(categoryDto, Category.class);
		Category save = categoryRepo.save(create);	
		return mapper.map(save,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> allCategory() {
		List<Category> all = categoryRepo.findAll();
		List<CategoryDto> collect = all.stream().map(e->mapper.map(e, CategoryDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		Category cat = categoryRepo.findById(id).orElseThrow();
		cat.setCategoryName(categoryDto.getCategoryName());
		Category save = categoryRepo.save(cat);
		return mapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto categoryById(int id) {
		Category cat = categoryRepo.findById(id).orElseThrow();
		return mapper.map(cat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Category cat = categoryRepo.findById(id).orElseThrow();
		categoryRepo.delete(cat);
		
	}

}
