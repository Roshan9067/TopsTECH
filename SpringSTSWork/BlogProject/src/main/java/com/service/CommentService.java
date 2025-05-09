package com.service;

import java.util.List;

import com.model.Comments;

public interface CommentService {
	
	public Comments addComment(Comments comments);
	public List<Comments> viewAllComments();
	public Comments updateCost(Comments comments,int id);
	public Comments commentById(int id);
	public void deleteComment(int id);

}
