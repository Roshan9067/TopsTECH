package com.service;

import java.util.List;

import com.payload.PostDto;


public interface PostService {
	
	public List<PostDto> allPost();
	public PostDto addPost(PostDto postDto,int uid,int catid);
	public PostDto updatePost(PostDto postDto , int id,int uid,int catid);
	public PostDto PostById(int id);
	public void deletePost(int id);

}

