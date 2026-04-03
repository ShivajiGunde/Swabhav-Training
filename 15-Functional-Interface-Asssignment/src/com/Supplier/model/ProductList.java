package com.Supplier.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ProductList {
	
	public static void main(String[] args) {
		

		
		Supplier<List<String>> productsList = () -> Arrays.asList("TV","Laptop","Mobile","Bulb","Remote");
		
		List<String> products = productsList.get();
		
		for(String p : products) {
			
			System.out.println(p);
		}
		
		
	}

}
