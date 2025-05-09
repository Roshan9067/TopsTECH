package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Category;
import com.model.Post;
import com.model.User;
import com.payload.CategoryDto;
import com.payload.PostDto;
import com.repo.CategoryRepo;
import com.repo.PostRepo;
import com.repo.UserRepo;
import com.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	UserRepo userRepo;

	@Override
	public List<PostDto> allPost() {
		// TODO Auto-generated method stub
		
		List<Post> alluser = postRepo.findAll();
		List<PostDto> collect = alluser.stream().map(e->mapper.map(e, PostDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public PostDto addPost(PostDto postDto, int uid, int catid) {
		Category category = categoryRepo.findById(catid).orElseThrow
				(()-> new ResourceNotFoundException("Category", "catid", catid));
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","uid", uid));
		Post post = mapper.map(postDto, Post.class);
		post.setCategory(category);
		post.setUser(user);
		post.setImage("test.png");
		
		Post create = postRepo.save(post);

		return mapper.map(create, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, int id, int uid, int catid) {
		
		Category category = categoryRepo.findById(catid).orElseThrow
				(()->new ResourceNotFoundException("Category", "catid", catid));
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User", "uid", uid));
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImage(postDto.getImage());
		post.setCategory(category);
		post.setUser(user);
		
		Post update = postRepo.save(post);
		return mapper.map(update, PostDto.class);
	}

	@Override
	public PostDto PostById(int id) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id)); 
		return mapper.map(post, PostDto.class);
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id)); 
		postRepo.delete(post);
	}

}
