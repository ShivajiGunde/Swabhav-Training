package com.stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordSort {

	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("Apple","Mango","Grapes","Laptop","Fan");
		
		List<String> sortedWords = words.stream()
								 .sorted(Comparator.comparing(s->s.length()))
								 .collect(Collectors.toList());
		
		System.out.println("Sort Words: " +sortedWords);
	}
}
