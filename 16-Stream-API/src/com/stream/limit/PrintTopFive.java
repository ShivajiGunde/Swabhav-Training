package com.stream.limit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintTopFive {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(13,23,12,34,50,90,45,10);
		
		numbers.stream().sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);
	}

}
