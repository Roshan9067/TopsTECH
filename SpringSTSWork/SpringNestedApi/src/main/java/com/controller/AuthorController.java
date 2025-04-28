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

import com.dto.AuthorDto;
import com.model.Auther;
import com.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {


	
	@Autowired
	AuthorService authorService;

  
  
	
	@PostMapping("/")
	    public ResponseEntity<AuthorDto> addAuthor(@RequestBody Auther author) {
		Auther createAuthor = authorService.addAuthor(author);
		
		AuthorDto dto = new AuthorDto();
		dto.setId(createAuthor.getId());
		dto.setName(createAuthor.getAuthor_name());
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/")
	public  ResponseEntity<List<AuthorDto>> allAuthers() {
		List<Auther> viewAuthor = authorService.allAuthors();
		
		List<AuthorDto> dto = new ArrayList<>();
		
		for(Auther a : viewAuthor) {
			
			AuthorDto dt = new AuthorDto();
			dt.setId(a.getId());
			dt.setName(a.getAuthor_name());
			
			dto.add(dt);
		}
		
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{aid}")
	public void deleteAuther(@PathVariable ("aid") int aid) {
		 authorService.deleteAuthor(aid);
	}
	
	
	@PutMapping("/{aid}")
	public ResponseEntity<Auther> updateAuthor(@RequestBody Auther author, @PathVariable ("aid") int aid) {
		Auther update = authorService.updateAuther(author, aid);
		return new ResponseEntity<>(update, HttpStatus.OK);
		
		
	}
}