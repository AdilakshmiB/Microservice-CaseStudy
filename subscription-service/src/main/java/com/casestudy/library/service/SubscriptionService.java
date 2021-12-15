package com.casestudy.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.library.BookServiceProxy;
import com.casestudy.library.bean.Book;
import com.casestudy.library.bean.Subscription;
import com.casestudy.library.repository.SubscriptionRepository;

@Service
@Transactional
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private BookServiceProxy proxy;

	public List<Subscription> getSubscriptions() {
		return subscriptionRepository.findAll();

	}

	@Transactional(rollbackFor = NoCopiesAvailableException.class)
	public boolean createSubsription(Subscription subscription) throws NoCopiesAvailableException {
		System.out.println("In post subscription");

		List<Book> books = proxy.getBooks();

		for (Book resultbook : books) {
			
			if (resultbook.getBookId() .equals(subscription.getBookId()) ) {
				
				Integer availableCopies = resultbook.getAvailableCopies();
				subscriptionRepository.save(subscription);
				if (availableCopies <= 0) {
					throw new NoCopiesAvailableException("No Copies Available");
				} else {
					subscriptionRepository.save(subscription);
					resultbook.setAvailableCopies(availableCopies - 1);
					proxy.updateBookCopies(resultbook);
					return true;
				}
			}
		}
		return false;
	}

	public void updateBookCopies(Book book) {
		proxy.updateBookCopies(book);
	}

	public List<Book> getSubscriptionsUsingFeign() {
		System.out.println("In getSubscriptions using fiegn");
		return proxy.getBooks();

	}

}