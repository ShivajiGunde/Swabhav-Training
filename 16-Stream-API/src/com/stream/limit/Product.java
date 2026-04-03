package com.stream.limit;

import java.util.Arrays;
import java.util.List;

public class Product {
	
	
	    public String name;
	    public int price;

	    public Product(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }
	
public static void main(String[] args) {
	

	List<Product> products = Arrays.asList(
	    new Product("Laptop", 700),
	    new Product("Mouse", 300),
	    new Product("Phone", 800),
	    new Product("Keyboard", 600)
	);

	products.stream()
	        .filter(p -> p.price > 500)
	        .limit(2)
	        .forEach(p -> System.out.println(p.name));

}

}
