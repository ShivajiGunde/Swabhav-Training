package com.stream.map;

import java.util.Arrays;
import java.util.List;

public class UpperCaseString {
	public static void main(String[] args) {
		
		List<String> name = Arrays.asList("Mahesh","Karan","Samadhan");
		
		name.stream().map(s->s.toUpperCase()).forEach(System.out::println);
	}

}
