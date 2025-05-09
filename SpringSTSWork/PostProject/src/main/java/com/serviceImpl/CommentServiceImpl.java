package com.serviceImpl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.CategoryDto;
import com.Dto.CommentDto;
import com.model.Comment;
import com.model.Post;
import com.model.User;
import com.repo.CommentRepo;
import com.repo.PostRepo;
import com.repo.UserRepo;
import com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	PostRepo postRepo;
	@Autowired
	ModelMapper mapper;

	@Override
	public CommentDto addComment(CommentDto commentDto, int uid, int pid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow();
		Post post = postRepo.findById(pid).orElseThrow();
		
		Comment add = mapper.map(commentDto, Comment.class);
		add.setPost(post);
		add.setUser(user);
		Comment save = commentRepo.save(add);
		
		return mapper.map(save, CommentDto.class);
	}

	@Override
	public List<CommentDto> allCommentd() {
		// TODO Auto-generated method stub
		List<Comment> all = commentRepo.findAll();
		List<CommentDto> collect = all.stream().map(e->mapper.map(e, CommentDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public CommentDto updateCommnet(CommentDto commentDto, int comid, int uid, int pid) {
		// TODO Auto-generated method stub
		Comment comment = commentRepo.findById(comid).orElseThrow();
		User user = userRepo.findById(uid).orElseThrow();
		Post post = postRepo.findById(pid).orElseThrow();
		comment.setUser(user);
		comment.setPost(post);
		comment.setComment(commentDto.getComment());
		Comment save = commentRepo.save(comment);
		return mapper.map(save, CommentDto.class);
	}

	@Override
	public CommentDto commentById(int id) {
		// TODO Auto-generated method stub
		Comment comment = commentRepo.findById(id).orElseThrow();
	
		return mapper.map(comment, CommentDto.class);
	}

	@Override
	public List<CommentDto> commentByUser(int id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow();
		List<Comment> byUser = commentRepo.findByUser(user);
		List<CommentDto> collect = byUser.stream().map(e->mapper.map(e, CommentDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteCommentById(int id) {
		// TODO Auto-generated method stub
		Comment comment = commentRepo.findById(id).orElseThrow();
		
		commentRepo.delete(comment);
		
		
	}

}
