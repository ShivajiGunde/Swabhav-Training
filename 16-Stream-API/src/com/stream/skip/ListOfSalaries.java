package com.stream.skip;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfSalaries {
	
	public static void main(String[] args) {
		
		List<Double> salaries = Arrays.asList(30000.0,20000.0,40000.0,70000.0);
		
     List<Double> reverseSkip2 = salaries.stream().sorted(Comparator.reverseOrder()).skip(2).collect(Collectors.toList());	
     
     System.out.println(reverseSkip2);
		
	}

}
