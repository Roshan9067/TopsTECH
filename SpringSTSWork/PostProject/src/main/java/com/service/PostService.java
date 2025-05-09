package com.service;

import java.util.List;

import com.Dto.PostDto;

public interface PostService {
	
	public PostDto addPost(PostDto postDto,int uid, int catid);
	public List<PostDto> allPost(int pageNumber, int pagesize,String sortBy, String sortType);
	public PostDto updatePost(PostDto posDto,int pid,int uid, int catid);
	public PostDto postById(int id);
	public List<PostDto> postByUser(int uid);
	public void deletePost(int id);
	public List<PostDto> postByCategory(int catid);
	public List<PostDto> searchPost(String keyword);
	public PostDto addImage(PostDto dto);
	

}
