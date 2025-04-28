package com.service;

import java.util.List;

import com.model.Auther;

public interface AuthorService {
	
	public List<Auther> allAuthors();
	public Auther addAuthor(Auther author);
	public Auther updateAuther(Auther auther, int id);
	public void deleteAuthor(int id);
	public Auther autherById(int id);
	

}
