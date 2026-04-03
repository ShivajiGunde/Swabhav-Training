package com.stream.filter;

import java.util.Arrays;
import java.util.List;

public class EmptyString {

	public static void main(String[] args) {
		
		List<String> str = Arrays.asList("Java","","Ganesh");
		
		str.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);
		
		
	}
}
