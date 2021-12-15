package com.casestudy.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.library.bean.Book;
import com.casestudy.library.service.BookService;

@RestController
public class BookServiceController {
	
	@Autowired
	private BookService bookService;

	
	  @GetMapping("/books") 
	  public List<Book>getBooks(){
		  System.out.println("In getBooks"); 
		  return bookService.getBooks(); 
	  
	  }
	 
	  @PostMapping("/book")
	  public void updateBookCopies(@RequestBody Book book) {
		  bookService.updateBookCopies(book);
	  }
}
