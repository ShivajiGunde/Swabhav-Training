package com.library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Library {
	
	private Set<Book> bookSet = new HashSet<>();
	private Queue<Book> issueQueue = new LinkedList<>();
	
	
	//add book
	public void addBook(Book book) {
		
		if(bookSet.add(book)) {
			System.out.println("Book added");
		}else {
			System.out.println("Duplicate book");
		}
	}
	
	
	//sorting by id
	public List<Book> sortById() {

		List<Book> sortById = new ArrayList<>(bookSet);

		Collections.sort(sortById, new Comparator<Book>() {

			@Override
			public int compare(Book b1,Book b2) {

				return Integer.compare(b1.getId(),b2.getId());
			}
		});
		return sortById;

	}
	
	//sorting by title
	public List<Book> sortByTitle() {

		List<Book> sortedByTitle = new ArrayList<>(bookSet);

		Collections.sort(sortedByTitle, new Comparator<Book>() {

			@Override
			public int compare(Book b1, Book b2) {

				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		return sortedByTitle;

	}
	
	
	//book request
	public void requestBook(Book book) {
	    if (book == null) {
	        System.out.println("Invalid book.");
	        return;
	    }

	    if (issueQueue.offer(book)) {
	        System.out.println("Request added.");
	    } else {
	        System.out.println("Queue is full.");
	    }
	}
	
	//process request
	 public void processRequests() {
	        while (!issueQueue.isEmpty()) {
	            Book b = issueQueue.poll();
	            System.out.println("Issuing: " + b);
	        }
	    }
	 
	 public void removeBook(int id) {
	        Iterator<Book> it = bookSet.iterator();
	        while (it.hasNext()) {
	            Book b = it.next();
	            if (b.getId() == id) {
	                it.remove();
	                System.out.println("Book removed.");
	            }
	        }
	    }

	 //display all
	 public void displayAll() {
	        for (Book b : bookSet) {
	            System.out.println(b);
	        }
	    }
	

}
