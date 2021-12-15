package com.casestudy.library.service;
public class NoCopiesAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoCopiesAvailableException(String cause) {
		super(cause);
	}

}