package com.service;

import java.util.List;

import com.model.Post;

public interface PostService {
	
	public Post addPost(Post post);
	public List<Post> viewAllPosts(); 
	public Post updatePost(Post post , int id);
	public Post postById(int id);
	public void deletePost(int id);
	

}
