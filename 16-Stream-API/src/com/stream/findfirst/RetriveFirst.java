package com.stream.findfirst;

import java.util.Arrays;
import java.util.List;

public class RetriveFirst {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Ram", "Shyam", "Amit");

		names.stream()
		     .findFirst()
		     .ifPresent(System.out::println);
	}

}
