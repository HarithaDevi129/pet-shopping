package com.example.pets.exception;

public class UserIdNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserIdNotFoundException(String exception) {
		super(exception);
	}
}
