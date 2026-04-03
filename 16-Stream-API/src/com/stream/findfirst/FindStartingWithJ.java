package com.stream.findfirst;

import java.util.Arrays;
import java.util.List;

public class FindStartingWithJ {
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("Apple", "Java", "Joy", "Ball");

		words.stream()
		     .filter(w -> w.startsWith("J"))
		     .findFirst()
		     .ifPresent(System.out::println);
	}

}
