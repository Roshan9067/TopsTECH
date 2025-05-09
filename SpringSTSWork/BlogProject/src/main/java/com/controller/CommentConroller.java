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

import com.dto.CommentDto;
import com.dto.PostDto;
import com.model.Comments;
import com.model.Post;
import com.service.CommentService;
import com.service.PostService;

@RestController
@RequestMapping("/comment")
public class CommentConroller {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	PostService postService;
	
	@PostMapping("/{pid}")
	public ResponseEntity<CommentDto> addComment(@RequestBody Comments comments , @PathVariable ("pid") int pid) {
		
		comments.setPost(postService.postById(pid));
		
		Comments addcoments = commentService.addComment(comments);
		
		CommentDto dto = new CommentDto();
		dto.setId(addcoments.getId());
		dto.setContent(addcoments.getContent());
		
		PostDto pdto = new PostDto();
		pdto.setId(addcoments.getId());
		pdto.setTitle(addcoments.getContent());
		pdto.setContent(addcoments.getContent());
		dto.setPostDto(pdto);
		
		
		
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
				
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CommentDto>> viewAllComments() {
		
		List<Comments> allComments = commentService.viewAllComments();
		
		List<CommentDto> dto = new ArrayList<>();
		
		for(Comments com : allComments) {
			
			CommentDto dt = new CommentDto();
			
			dt.setId(com.getId());
			dt.setContent(com.getContent());
			
			dto.add(dt);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comments> updateComment(@RequestBody Comments comments, @PathVariable ("id") int id) {
		
		Comments update = commentService.updateCost(comments, id);
		
		return new ResponseEntity<>(update, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteComment(@PathVariable ("id") int id) {
		
		commentService.deleteComment(id);
		
	}
	
	
	
	
	
	
	
	
	
	

}
