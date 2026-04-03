package com.library.model;

import java.util.Objects;


public abstract class Book implements Comparable<Book>{

	private int id;
	private String title;
	private String author;

	public Book(int id, String title, String author) {
		super();
		
		if (id <= 0) {

			throw new IllegalArgumentException("Patient id cannot be negative");
		}
		this.id = id;
		
		if (title.isEmpty() || !title.matches("[a-zA-Z]+")) {

			throw new IllegalArgumentException("Title cannot be null");
		}
		this.title = title;
		
		if (author.isEmpty() || !author.matches("[a-zA-Z]+")) {

			throw new IllegalArgumentException("Author cannot be null");
		}
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
    public abstract String getType();
    
    
    @Override
	public int compareTo(Book b) {

		return Integer.compare(b.getId(), this.getId());
	}

    @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;
		Book b = (Book) o;
		return id == b.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public String toString() {

		return "Id: " + id + "Title: " + title + "Author: " + author+ "Type: "+getType();

	}

}
