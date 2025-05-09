package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CategoryDto;
import com.model.Category;
import com.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody Category category) {
		
		Category add = categoryService.addCategory(category);
		
		CategoryDto dto = new CategoryDto();
		
		dto.setId(add.getId());
		dto.setTitle(add.getTitle());
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
			
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> viewCategory() {
		
		List<Category> view = categoryService.viewAllCategory();
		
		List<CategoryDto> dto = new ArrayList<>();
		for(Category c : view) {
			
			CategoryDto dt = new CategoryDto();
			
			dt.setId(c.getId());
			dt.setTitle(c.getTitle());
			
			dto.add(dt);
		}
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable ("id") int id) {
		
		Category update = categoryService.updateCategory(category, id);
		
		return new ResponseEntity<>(update, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable ("id") int id) {
		
		categoryService.deleteCategory(id);
		
	}

}
