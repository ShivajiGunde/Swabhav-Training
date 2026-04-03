package com.stream.filter;

import java.util.Arrays;
import java.util.List;


public class ProductMain {
	
	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(new Product(101, "TV", 6000),
												new Product(102, "Remote", 200),
												new Product(103, "Desktop", 20000),
												new Product(104, "Mouse",100));
		
		products.stream().filter(p ->p.price > 500).forEach(System.out::println);
	}

}
