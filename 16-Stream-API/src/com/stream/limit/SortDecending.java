package com.stream.limit;

import java.util.Arrays;
import java.util.List;

public class SortDecending {
	public static void main(String[] args) {
		
	
	List<String> words = Arrays.asList("apple", "banana", "kiwi", "watermelon", "grape");

	     words.stream()
	     .sorted((a, b) -> b.length() - a.length())
	     .limit(3)
	     .forEach(System.out::println);

  }
}
