package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Auther;
import com.model.Book;
import com.model.Publication;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	
	public List<Book> findByAut(Auther auther);
	public List<Book> findByPub(Publication pub);

}
