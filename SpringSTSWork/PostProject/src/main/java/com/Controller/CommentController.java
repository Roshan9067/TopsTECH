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

import com.Dto.CommentDto;
import com.repo.CategoryRepo;
import com.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CategoryRepo categoryRepo;
	
	@Autowired
	CommentService service;


    CommentController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
	
	
	@PostMapping("/{uid}/{pid}")
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto,@PathVariable ("uid") int uid,@PathVariable ("pid") int pid) {
		
		CommentDto comment = service.addComment(commentDto, uid, pid);
		return new ResponseEntity<>(comment, HttpStatus.CREATED);
	}
	
	@GetMapping("/comm")
	public ResponseEntity<List<CommentDto>> allComments() {
		List<CommentDto> allCommentd = service.allCommentd();
		return new ResponseEntity<>(allCommentd, HttpStatus.OK);
		
	}
	@PutMapping("/{cid}/{uid}/{pid}")
	public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,
			@PathVariable ("cid") int cid,
			@PathVariable ("uid") int uid,
			@PathVariable ("pid") int pid) {
		
		CommentDto updateCommnet = service.updateCommnet(commentDto, cid, uid, pid);
		return new ResponseEntity<>(updateCommnet, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteComments(@PathVariable ("id") int id) {
		service.deleteCommentById(id);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommentDto> commentById(@PathVariable ("id") int id) {
		CommentDto commentById = service.commentById(id);
		return new ResponseEntity<>(commentById, HttpStatus.OK);
	}
	

}
