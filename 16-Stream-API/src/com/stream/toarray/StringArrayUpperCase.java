package com.stream.toarray;

import java.util.Arrays;

public class StringArrayUpperCase {
	
	public static void main(String[] args) {
		
		String[] arr = {"Mahesh","Raja","Ganesh","Manoj"};
		
		Arrays.stream(arr).map(s->s.toUpperCase()).forEach(System.out::println);
	}

}
