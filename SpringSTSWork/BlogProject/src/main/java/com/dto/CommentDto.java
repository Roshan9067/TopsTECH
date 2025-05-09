package com.dto;

public class CommentDto {
	
	private int id;
	private String content;
	private PostDto postDto;
	
	public PostDto getPostDto() {
		return postDto;
	}
	public void setPostDto(PostDto postDto) {
		this.postDto = postDto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
