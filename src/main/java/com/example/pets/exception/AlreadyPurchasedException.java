package com.example.pets.exception;

public class AlreadyPurchasedException  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AlreadyPurchasedException(String exception) {
		super(exception);
	}
}
