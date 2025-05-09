package com.cotroller;

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

import com.payload.CategoryDto;
import com.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addUser(@RequestBody CategoryDto categoryDto) {
		
		CategoryDto createCategory = service.addCategory(categoryDto);
		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> allCategory() {
		List<CategoryDto> view = service.allCategory();
		
		return new ResponseEntity<>(view, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> categoryById(@PathVariable ("id") int id) {
		CategoryDto category = service.categoryById(id);
		return new ResponseEntity<>(category, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable ("id") int id) {
		
		CategoryDto update = service.updateCategory(categoryDto, id);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable ("id") int id) {
		
		service.deleteCategory(id);
		
	}

}
