package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Auther;
import com.model.Book;
import com.model.Publication;
import com.repo.AuthorRepo;
import com.repo.BookRepo;
import com.repo.PublicationRepo;
import com.service.BookService;

@Service
public class BookImpl implements BookService{
	
	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	AuthorRepo autherRepo;
	
	@Autowired
	PublicationRepo publicationRepo;

	@Override
	public List<Book> allBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll() ;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Book book, int id) {
		// TODO Auto-generated method stub
		book.setId(id);
		return bookRepo.save(book);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
		bookRepo.deleteById(id);
	}

	@Override
	public Book bookById(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Book> bookByAuthor(int aid) {
		// TODO Auto-generated method stub
		Auther auther = autherRepo.findById(aid).orElseThrow();
		return bookRepo.findByAut(auther);
	}

	@Override
	public List<Book> bookByPublication(int pid) {
		// TODO Auto-generated method stub
		Publication pub = publicationRepo.findById(pid).orElseThrow();
		return bookRepo.findByPub(pub);
		
	}

}
