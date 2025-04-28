 package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthorDto;
import com.dto.BookDto;
import com.dto.PublicationDto;
import com.model.Book;
import com.service.AuthorService;
import com.service.BookService;
import com.service.PublicationService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;

	@Autowired
	PublicationService publicationService;
	
	@Autowired
	AuthorService authorService;
	
	@PostMapping("/{aid}/{pid}")
	public ResponseEntity<BookDto> addBooks(@RequestBody Book book , @PathVariable ("aid") int aid, @PathVariable ("pid") int pid) {
		
		book.setAut(authorService.autherById(aid));
		book.setPub(publicationService.publicationById(pid));
		
		Book createBook = bookService.addBook(book);
		
		BookDto dto = new BookDto();
		dto.setId(createBook.getId());
		dto.setName(createBook.getName());
		dto.setPrice(createBook.getPrice());
		
		
		AuthorDto adto = new AuthorDto();
		adto.setId(createBook.getAut().getId());
		adto.setName(createBook.getAut().getAuthor_name());
		dto.setAuthorDto(adto);
		
		
		PublicationDto pdto = new PublicationDto();
		pdto.setId(createBook.getPub().getId());
		pdto.setName(createBook.getPub().getPublication_name());
		dto.setPublicationDto(pdto);
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<BookDto>> showAllBooks() {
		
		List<Book> allBooks = bookService.allBooks();
		
		List<BookDto> dto = new ArrayList<>();
		
		for(Book b : allBooks) {
			
			BookDto dt = new BookDto();
			
			dt.setId(b.getId());
			dt.setName(b.getName());
			dt.setPrice(b.getPrice());
			

			AuthorDto adto = new AuthorDto();
			adto.setId(b.getAut().getId());
			adto.setName(b.getAut().getAuthor_name());
			dt.setAuthorDto(adto);
			
			
			
			PublicationDto pdto = new PublicationDto();
			pdto.setId(b.getPub().getId());
			pdto.setName(b.getPub().getPublication_name());
			dt.setPublicationDto(pdto);
			
			dto.add(dt);
			
			
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{bid}")
	public void deleteBook(@PathVariable ("bid") int bid) {
		bookService.deleteBook(bid);
		
	}
	
	@PutMapping("/{bid}/{aid}/{pid}")
	public ResponseEntity<BookDto> updateBook(@RequestBody Book book,@PathVariable("bid") int bid,@PathVariable("aid") int aid  ,@PathVariable("pid") int pid){
		
		book.setAut(authorService.autherById(aid));
		book.setPub(publicationService.publicationById(pid));
		Book update= bookService.updateBook(book, bid);
		
		BookDto dto = new BookDto();
		dto.setId(update.getId());
		dto.setName(update.getName());
		dto.setPrice(update.getPrice());
		
		
		AuthorDto adto = new AuthorDto();
		adto.setId(update.getAut().getId());
		adto.setName(update.getAut().getAuthor_name());
		dto.setAuthorDto(adto);
		
		
		PublicationDto pdto = new PublicationDto();
		pdto.setId(update.getPub().getId());
		pdto.setName(update.getPub().getPublication_name());
		dto.setPublicationDto(pdto);
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
		
	}
	
	

}
