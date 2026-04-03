package com.stream.sorted;

import java.util.Arrays;
import java.util.List;

public class StringSort {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Mahesh","Ganesh","Aman","Balaji","Ram","Laxman","Mangesh");
		
		names.stream().sorted().forEach(System.out::println);
	}

}
