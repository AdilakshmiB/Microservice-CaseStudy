package com.casestudy.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.library.bean.Book;
import com.casestudy.library.bean.Subscription;
import com.casestudy.library.service.NoCopiesAvailableException;
import com.casestudy.library.service.SubscriptionService;

@RestController
public class SubscriptionServiceController {

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping("/subscriptions") 
	public List<Subscription> getSubscriptions(){
		System.out.println("In getSubscriptions"); 
		return subscriptionService.getSubscriptions(); 

	}

	@GetMapping("/subscriptions/{subscriberName}") 
	public List<Subscription> getSubscriptionsByName( @PathVariable String subscriberName){
		System.out.println("In getSubscriptions"); 
		return subscriptionService.getSubscriptions(); 

	}

	@GetMapping("/subscriptions-feign") 
	public List<Book> getSubscriptionsUsingFeign(){
		System.out.println("In getSubscriptions using fiegn"); 
		return subscriptionService.getSubscriptionsUsingFeign(); 

	}


	@PostMapping("/bookSubscriptions") 
	public ResponseEntity<Book> postSubscription(@RequestBody Subscription subscription ){
		System.out.println("In post subscription"); 


		boolean resultFlag = false;
		try {
			resultFlag = subscriptionService.createSubsription(subscription);
		} catch (NoCopiesAvailableException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if(resultFlag) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);


	}




}


