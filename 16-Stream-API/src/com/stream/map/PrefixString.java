package com.stream.map;

import java.util.Arrays;
import java.util.List;

public class PrefixString {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Hanmant","Karan","Manoj");
		
		names.stream().map(name->("Mr." +name)).forEach(System.out::println);
		
		
		
		
	}

}
