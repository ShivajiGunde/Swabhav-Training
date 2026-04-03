package com.stream.filter;

import java.util.Arrays;
import java.util.List;

public class PrintNames {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Aman","Gagan","Lokesh","Ganesh","Akash");
		
		names.stream().filter(s-> s.startsWith("A")).forEach(System.out::println);
				
	}

}
