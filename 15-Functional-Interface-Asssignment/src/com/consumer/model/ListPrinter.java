package com.consumer.model;

import java.util.List;
import java.util.function.Consumer;

public class ListPrinter {
	
	public static void main(String[] args) {
		
		//Consumer<List<String>> listPrinter = items -> 
		
		 Consumer<List<String>> printList = list -> {
	            for (String item : list) {
	                System.out.println(item);
	            }
	        };

	        List<String> names = List.of("Alice", "Bob", "Charlie");

	        printList.accept(names);
	}

}
