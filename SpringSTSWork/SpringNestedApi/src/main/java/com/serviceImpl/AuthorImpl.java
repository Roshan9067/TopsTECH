package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Auther;
import com.repo.AuthorRepo;
import com.service.AuthorService;

@Service
public class AuthorImpl implements AuthorService{
	
	@Autowired
	AuthorRepo authorRepo;

	@Override
	public List<Auther> allAuthors() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}

	@Override
	public Auther addAuthor(Auther author) {
		// TODO Auto-generated method stub
		return authorRepo.save(author);
	}

	@Override
	public Auther updateAuther(Auther auther, int id) {
		// TODO Auto-generated method stub
		auther.setId(id);
		return authorRepo.save(auther);
	}

	@Override
	public void deleteAuthor(int id) {
		// TODO Auto-generated method stub
		authorRepo.deleteById(id);
		
	}

	@Override
	public Auther autherById(int id) {
		// TODO Auto-generated method stub
		return authorRepo.findById(id).orElseThrow();
	}

}
