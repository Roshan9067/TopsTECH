package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
