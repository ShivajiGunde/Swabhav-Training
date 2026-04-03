package com.stream.findfirst;

import java.util.Arrays;
import java.util.List;

import com.stream.limit.Product;

public class FirstProduct {
	
	String name;
    int price;

	FirstProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

	public static void main(String[] args) {

		List<Product> products = Arrays.asList(new Product("Laptop", 700), new Product("Mouse", 300),
				new Product("Phone", 800), new Product("Keyboard", 600));

		products.stream().filter(p -> p.price > 500).findFirst().ifPresent(p -> System.out.println(p.name));
	}
}
