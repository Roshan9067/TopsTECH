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
import com.dto.PostDto;
import com.dto.UserDto;
import com.model.Post;
import com.service.CategoryService;
import com.service.CommentService;
import com.service.PostService;
import com.service.UserService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/{uid}/{catid}")
	public ResponseEntity<PostDto> addPost(@RequestBody Post post,@PathVariable ("uid") int uid,@PathVariable ("catid") int catid) {
		
		post.setCategory(categoryService.categoryById(catid));
		post.setUser(userService.userById(uid));
		
		
		Post addPost = postService.addPost(post);
		
		PostDto pdto = new PostDto();
		pdto.setId(addPost.getId());
		pdto.setTitle(addPost.getTitle());
		pdto.setContent(addPost.getContent());
		
		UserDto udto = new UserDto();
		udto.setId(addPost.getUser().getId());
		udto.setName(addPost.getUser().getName());
		udto.setEmail(addPost.getUser().getEmail());
		udto.setPassword(addPost.getUser().getPassword());
		pdto.setUserDto(udto);
		
		CategoryDto cdto = new CategoryDto();
		
		cdto.setId(addPost.getCategory().getId());
		cdto.setTitle(addPost.getCategory().getTitle());
		pdto.setCategoryDto(cdto);
		
		return new ResponseEntity<>(pdto, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> viewAllPost() {
		List<Post> viewpost = postService.viewAllPosts();
		
		List<PostDto> dto = new ArrayList<>();
		
		for(Post p:viewpost) {
			
			PostDto pdto = new PostDto();
			pdto.setId(p.getId());
			pdto.setTitle(p.getTitle());
			pdto.setContent(p.getContent());
			

			UserDto udto = new UserDto();
			udto.setId(p.getUser().getId());
			udto.setName(p.getUser().getName());
			udto.setEmail(p.getUser().getEmail());
			udto.setPassword(p.getUser().getPassword());
			pdto.setUserDto(udto);
			
			CategoryDto cdto = new CategoryDto();
			cdto.setId(p.getCategory().getId());
			cdto.setTitle(p.getCategory().getTitle());
			pdto.setCategoryDto(cdto);
			
			dto.add(pdto);
			
			
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable ("id") int id) {
		postService.deletePost(id);		
	}
	
	@PutMapping("/{pid}/{uid}/{catid}")
	public ResponseEntity<PostDto> updatePost(@RequestBody Post post,@PathVariable ("pid") int pid, @PathVariable ("uid") int uid,@PathVariable ("catid") int catid) {
		post.setCategory(categoryService.categoryById(catid));
		post.setUser(userService.userById(uid));
		
		Post addPost = postService.updatePost(post, pid);
		
		PostDto pdto = new PostDto();
		pdto.setId(addPost.getId());
		pdto.setTitle(addPost.getTitle());
		pdto.setContent(addPost.getContent());
		
		UserDto udto = new UserDto();
		udto.setId(addPost.getUser().getId());
		udto.setName(addPost.getUser().getName());
		udto.setEmail(addPost.getUser().getEmail());
		udto.setPassword(addPost.getUser().getPassword());
		pdto.setUserDto(udto);
		
		CategoryDto cdto = new CategoryDto();
		
		cdto.setId(addPost.getCategory().getId());
		cdto.setTitle(addPost.getCategory().getTitle());
		pdto.setCategoryDto(cdto);
		
		return new ResponseEntity<>(pdto, HttpStatus.CREATED);
		
		
		
	}
	

}


