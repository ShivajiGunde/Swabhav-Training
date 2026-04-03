package com.stream.limit;

import java.util.Arrays;
import java.util.List;

public class StudentList {
	public static void main(String[] args) {
		
	
	List<String> names = Arrays.asList("Amit", "Rahul", "Sneha", "Priya", "John");

	names.stream()
	     .limit(3)
	     .forEach(System.out::println);

}
}
