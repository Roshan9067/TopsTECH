package com.Controller;

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

import com.Dto.CategoryDto;
import com.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addVCategory(@RequestBody CategoryDto categoryDto) {	
		CategoryDto category = service.addCategory(categoryDto);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> allCategory() {
		List<CategoryDto> allCategory = service.allCategory();
		return new ResponseEntity<>(allCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletCategory(@PathVariable ("id") int id) {
		service.deleteCategory(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable ("id") int id,@RequestBody CategoryDto categoryDto) {
		CategoryDto updateCategory = service.updateCategory(categoryDto, id);
		return new ResponseEntity<>(updateCategory, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> categoryById(@PathVariable ("id") int id) {
		CategoryDto categoryById = service.categoryById(id);
		return new ResponseEntity<>(categoryById, HttpStatus.OK);
		
		
	}

}
