package com.casestudy.library;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casestudy.library.bean.Book;
import com.casestudy.library.bean.Subscription;

@FeignClient(name="book-service", url="localhost:9777")
public interface BookServiceProxy {
	
	@GetMapping("/books") 
	public List<Book> getBooks();
	
	@PostMapping("/book")
	public void updateBookCopies(@RequestBody Book book);

}
