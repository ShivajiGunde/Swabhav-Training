package com.stream.skip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkipFirstThree {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Manoj","Ganesh","Raju","Akash","Lokesh","Gagan");
		
		List<String> skip3 = names.stream().skip(3).collect(Collectors.toList());
		
		System.out.println(skip3);
		
		
	}

}
