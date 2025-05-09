package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Post;
import com.repo.PostRepo;
import com.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepo repo;

	@Override
	public Post addPost(Post post) {
		// TODO Auto-generated method stub
		return repo.save(post);
	}

	@Override
	public List<Post> viewAllPosts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Post updatePost(Post post, int id) {
		// TODO Auto-generated method stub
		post.setId(id);
		return repo.save(post);
	}

	@Override
	public Post postById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
