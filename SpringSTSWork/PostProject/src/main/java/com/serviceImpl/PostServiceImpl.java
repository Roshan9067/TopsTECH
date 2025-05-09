package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Dto.PostDto;
import com.model.Category;
import com.model.Post;
import com.model.User;
import com.repo.CategoryRepo;
import com.repo.PostRepo;
import com.repo.UserRepo;
import com.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo repo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	UserRepo userRepo;

	@Autowired
	ModelMapper mapper;

	@Override
	public PostDto addPost(PostDto postDto, int uid, int catid) {
		// TODO Auto-generated method stub
		Category category = categoryRepo.findById(catid).orElseThrow();
		User user = userRepo.findById(uid).orElseThrow();
		Post add = mapper.map(postDto, Post.class);
		add.setCategory(category);
		add.setUser(user);
		Post save = repo.save(add);
		return mapper.map(save, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto posDto, int pid, int uid, int catid) {
		// TODO Auto-generated method stub
		Post post = repo.findById(pid).orElseThrow();
		Category category = categoryRepo.findById(catid).orElseThrow();
		User user = userRepo.findById(uid).orElseThrow();
		post.setCategory(category);
		post.setUser(user);
		post.setTitle(posDto.getTitle());
		post.setContent(posDto.getContent());
		post.setImg(posDto.getImg());

		Post save = repo.save(post);

		return mapper.map(save, PostDto.class);
	}

	@Override
	public PostDto postById(int id) {
		// TODO Auto-generated method stub
		Post post = repo.findById(id).orElseThrow();
		return mapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> postByUser(int uid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow();
		List<Post> byUser = repo.findByUser(user);
		List<PostDto> collect = byUser.stream().map(e -> mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		Post post = repo.findById(id).orElseThrow();
		repo.delete(post);

	}

	@Override
	public List<PostDto> postByCategory(int catid) {
		// TODO Auto-generated method stub
		Category category = categoryRepo.findById(catid).orElseThrow();
		List<Post> byCategory = repo.findByCategory(category);
		List<PostDto> collect = byCategory.stream().map(e -> mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> allPost(int pageNumber, int pagesize, String sortBy, String sortType) {
		// TODO Auto-generated method stub
		Sort sort;

		if (sortType.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}

		Pageable pageable = PageRequest.of(pageNumber, pagesize, sort);
		Page<Post> postPage = repo.findAll(pageable);

		List<Post> content = postPage.getContent();

		List<PostDto> collect = content.stream().map(e -> mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub

		List<Post> byTitleContaining = repo.findByTitleContaining(keyword);
		List<PostDto> collect = byTitleContaining.stream().map(e -> mapper.map(e, PostDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public PostDto addImage(PostDto dto) {
		Post post = mapper.map(dto, Post.class);
		Post createdPost = repo.save(post);
		return mapper.map(createdPost, PostDto.class);
	}

}
