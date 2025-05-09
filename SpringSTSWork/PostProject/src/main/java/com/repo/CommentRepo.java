package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Comment;
import com.model.User;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	public List<Comment> findByUser(User user);

}
