package com.dto;

public class PostDto {
	
	private int id;
	private String title;
	private String content;
	private UserDto userDto;
	private CategoryDto categoryDto;
	public int getId() {
		return id;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public CategoryDto getCategoryDto() {
		return categoryDto;
	}
	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
