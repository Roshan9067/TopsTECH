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

import com.payload.PostDto;
import com.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/{uid}/{catid}")
	public ResponseEntity<PostDto> addPost(@RequestBody PostDto dto,
			@PathVariable ("uid") int uid,
			@PathVariable ("catid") int catid) {
		
		PostDto create = postService.addPost(dto, uid, catid);
		
		return new ResponseEntity<>(create, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> viewAll() {
		
		List<PostDto> all = postService.allPost();
		return new ResponseEntity<>(all, HttpStatus.OK);
		
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<PostDto> postById(@PathVariable ("pid") int pid) {
		
		PostDto postById = postService.PostById(pid);
		return new ResponseEntity<>(postById, HttpStatus.OK);
		
	}
	
	@PutMapping("/{pid}/{uid}/{catid}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto dto,
			@PathVariable ("pid") int pid,
			@PathVariable ("uid") int uid,
			@PathVariable ("catid") int catid) {
		
		PostDto update = postService.updatePost(dto, pid, uid, catid);
		return new ResponseEntity<>(update, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{pid}")
	public void delete(@PathVariable ("pid") int pid) {
		
		postService.deletePost(pid);
		
	}

}
