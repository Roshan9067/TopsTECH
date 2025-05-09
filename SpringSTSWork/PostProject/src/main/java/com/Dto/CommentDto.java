package com.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
	private int id;
	private String comment;
	private UserDto user;
	private PostDto post;

}
