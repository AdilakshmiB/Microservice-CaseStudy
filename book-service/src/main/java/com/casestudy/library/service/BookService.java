package com.casestudy.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.library.bean.Book;
import com.casestudy.library.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks() {
		return bookRepository.findAll();
		
	}
	
	public void updateBookCopies(Book book) {
		bookRepository.save(book);
	}
}