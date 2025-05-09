package com.service;

import java.util.List;

import com.Dto.CommentDto;

public interface CommentService {
	
	public CommentDto addComment(CommentDto commentDto,int uid, int pid);
	public List<CommentDto> allCommentd();
	public CommentDto updateCommnet(CommentDto commentDto,int comid, int uid,int pid);
	public CommentDto commentById(int id);
	public List<CommentDto> commentByUser(int id);
	public void deleteCommentById(int id);
	

}
