package com.stream.sorted;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IncreasingOrder {
	public static void main(String[] args) {
		
		List<Integer> num = Arrays.asList(10,40,30,60);
		
		List<Integer> sorted =  num.stream().sorted().collect(Collectors.toList());
		
		System.out.println("Sorted: "+sorted);
		
		
	}

}
