package com.stream.count;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductCountMain {

	public static void main(String[] args) {

//		List<Double> prices = Arrays.asList(1000.0,6000.0,400.0,300.0,7000.0);
//
//		long count = prices.stream().map(price -> price * 0.8).filter(price -> price > 500).count();

		 List<Double> prices = Arrays.asList(600.0, 1200.0, 400.0, 800.0, 300.0);

	        long count = prices.stream()
	                .map(price -> price * 0.8)         
	                .filter(price -> price > 500)       
	                .count();                            

	        System.out.println("Number of products costing above ₹500 after discount: " + count);
	    }
	}


