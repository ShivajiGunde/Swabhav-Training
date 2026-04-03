package com.stream.toarray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConverList {
	
	public static void main(String[] args) {
		
		String[] arr = {"Mahesh","Raja","Ganesh","Manoj"};
		
		List<String>list = Arrays.stream(arr).collect(Collectors.toList());
		
		System.out.println(list);

	}

}
