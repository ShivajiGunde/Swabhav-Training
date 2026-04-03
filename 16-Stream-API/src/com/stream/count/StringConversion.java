package com.stream.count;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConversion {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("Mahesh", "Arati", "Akash", "Ganesh");

		List<String> upperCase = names.stream().map(String :: toUpperCase).collect(Collectors.toList());

	    System.out.println("UpperCase: "+upperCase);
	
		long countNames = names.stream().filter(s -> s.startsWith("A")).count();

		System.out.println("Count start with A " + countNames);

	}

}
