package com.service;

import java.util.List;
import com.model.Book;

public interface BookService {
	
	public List<Book> allBooks();
	public Book addBook(Book book);
	public Book updateBook(Book book,int id);
	public void deleteBook(int id);
	public Book bookById(int id);
	public List<Book> bookByAuthor(int aid);
	public List<Book> bookByPublication(int pid);

}
