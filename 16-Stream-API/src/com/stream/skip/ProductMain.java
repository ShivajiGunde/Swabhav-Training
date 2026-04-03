package com.stream.skip;

import java.util.Arrays;
import java.util.List;

public class ProductMain {
	
	public static void main(String[] args) {
		
		  List<Product> products = Arrays.asList(
		            new Product("Laptop", 75000),
		            new Product("Mouse", 700),
		            new Product("Keyboard", 1200),
		            new Product("Pen", 50),
		            new Product("Monitor", 15000),
		            new Product("Book", 400)
		        );

		        products.stream()
		                .filter(p -> p.price > 500) 
		                .skip(2)                   
		                .forEach(System.out::println);
		    }

}
