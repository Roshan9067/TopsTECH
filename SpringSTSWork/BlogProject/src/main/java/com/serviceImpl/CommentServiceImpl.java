package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Comments;
import com.repo.CommentRepo;
import com.service.CommentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepo repo;

	@Override
	public Comments addComment(Comments comments) {
		// TODO Auto-generated method stub
		return repo.save(comments);
	}

	@Override
	public List<Comments> viewAllComments() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Comments updateCost(Comments comments, int id) {
		// TODO Auto-generated method stub
		comments.setId(id);
		return repo.save(comments);
	}

	@Override
	public Comments commentById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
