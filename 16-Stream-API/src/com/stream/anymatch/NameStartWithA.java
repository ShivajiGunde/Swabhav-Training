package com.stream.anymatch;

import java.util.Arrays;
import java.util.List;

public class NameStartWithA {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Ram", "Amit", "Shyam");

		boolean result = names.stream()
		                      .anyMatch(n -> n.startsWith("A"));

		System.out.println(result);
	}

}
