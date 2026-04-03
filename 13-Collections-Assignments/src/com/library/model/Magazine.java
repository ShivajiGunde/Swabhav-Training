package com.library.model;

public class Magazine extends Book{
	
	private int issuedNumber;

	public Magazine(int id, String title, String author,int issuedNumber) {
		super(id, title, author);
		
		if (issuedNumber <= 0) {

			throw new IllegalArgumentException("issuedNumber cannot be negative");
		}
		this.issuedNumber = issuedNumber;
	}

	@Override
	public String getType() {
		return "Magazine";
	}

}
