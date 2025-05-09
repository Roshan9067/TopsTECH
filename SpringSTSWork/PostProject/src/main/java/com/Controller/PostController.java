package com.Controller;


import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Dto.PostDto;
import com.service.ImgService;
import com.service.PostService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService service;
	@Autowired
	ImgService imgService;
	
	@Value("${project.image}")
	String path;
	
	@PostMapping("/user/{uid}/cat/{catid}")
	public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto,@PathVariable ("uid") int uid,
			@PathVariable ("catid") int catid) {
		
		PostDto post = service.addPost(postDto, uid, catid);
		return new ResponseEntity<>(post, HttpStatus.CREATED);
		
	}
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> allPost(
			@RequestParam(value ="pageNumber", defaultValue ="0") int pageNumber,
			@RequestParam(value="pageSize", defaultValue ="5") int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value = "sortType", defaultValue = "asc") String sortType) {
		List<PostDto> allPost = service.allPost(pageNumber, pageSize, sortBy, sortType);
		return new ResponseEntity<>(allPost, HttpStatus.OK);
		
	}
	
	@PutMapping("/{pid}/{uid}/{catid}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto dto,@PathVariable ("uid") int uid,
			@PathVariable ("catid") int catid,
			@PathVariable ("pid") int pid) {
		PostDto updatePost = service.updatePost(dto, pid, uid, catid);
		return new ResponseEntity<>(updatePost, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ("id") int id) {
		service.deletePost(id);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> postById(@PathVariable ("id") int id) {
		PostDto postById = service.postById(id);
		return new ResponseEntity<>(postById, HttpStatus.OK);
		
	}
	
	@GetMapping("/cat/{catid}")
	public ResponseEntity<List<PostDto>> postByCategory(@PathVariable ("catid") int catid) {
		List<PostDto> postByCategory = service.postByCategory(catid);
		return new ResponseEntity<>(postByCategory, HttpStatus.OK);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<PostDto>> postByUser(@PathVariable ("uid") int uid) {
		List<PostDto> postByUser = service.postByUser(uid);
		return new ResponseEntity<>(postByUser,HttpStatus.OK);
		
	}
	@GetMapping("/key/{keyword}")
	public ResponseEntity<List<PostDto>> searchByKeword(@PathVariable ("keyword") String keyword) {
		List<PostDto> searchPost = service.searchPost(keyword);
		return new ResponseEntity<>(searchPost, HttpStatus.OK);
		
	}
	
	@PostMapping("/upload/{pid}")
	public ResponseEntity<PostDto> uploadImg(@PathVariable("pid") int pid,
			@RequestParam("img") MultipartFile file) {
		
		System.out.println(pid +" hh");
		PostDto postById = service.postById(pid);
		String image = imgService.upload(path, file);
		postById.setImg(image);
		
		PostDto createImage = service.addImage(postById);
		return new ResponseEntity<>(createImage, HttpStatus.CREATED);
	}
	
	@GetMapping(produces = MediaType.IMAGE_JPEG_VALUE,value = "/image/{imagename}")
	public ResponseEntity<Resource> dowmloadImg(@PathVariable("imagename") String imgname,
			HttpServletResponse resp) {
		
		InputStream is = imgService.getImg(path, imgname);
		Resource resource = new InputStreamResource(is);
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(resource);

	}
	

}
