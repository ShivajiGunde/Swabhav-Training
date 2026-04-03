package com.stream.map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPricesMain {
	public static void main(String[] args) {
		
		List<ProductsPrices> products = Arrays.asList(new ProductsPrices("Fan",3000),
														new ProductsPrices("Fridge", 10000));
		
		List<Double> newPrices = products.stream().map( p -> p.price * 0.9).collect(Collectors.toList());
		
		System.out.println(newPrices);
	}

}
