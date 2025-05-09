package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
