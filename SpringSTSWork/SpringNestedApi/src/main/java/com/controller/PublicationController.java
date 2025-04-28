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

import com.dto.PublicationDto;
import com.model.Publication;
import com.service.PublicationService;

@RestController
@RequestMapping("/publication")
public class PublicationController {
	
	@Autowired
	PublicationService publicationService;
	
	@PostMapping("/")
	public ResponseEntity<PublicationDto> addPublication(@RequestBody Publication pub) {
		
		Publication createPublication = publicationService.addPublication(pub);
		
		PublicationDto dto = new PublicationDto();
		
		dto.setId(createPublication.getId());
		dto.setName(createPublication.getPublication_name());
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PublicationDto>> allPublications() {
		List<Publication> showPublications = publicationService.allPublications();
		
		List<PublicationDto> dto = new ArrayList<>();
		
		for(Publication p : showPublications) {
			
			PublicationDto dt = new PublicationDto();
			
			dt.setId(p.getId());
			dt.setName(p.getPublication_name());
			dto.add(dt);
		}
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{pid}")
	public void deletePublication(@PathVariable ("pid") int pid) {
		publicationService.deletePublication(pid);
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<Publication> updatePublication(@RequestBody Publication pub, @PathVariable ("pid") int pid) {
		
		Publication update = publicationService.updatePublication(pub, pid);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

}
