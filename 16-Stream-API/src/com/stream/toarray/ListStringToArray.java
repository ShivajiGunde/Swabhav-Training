package com.stream.toarray;

import java.util.Arrays;
import java.util.List;

public class ListStringToArray {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Mobile","Laptop","Desktop");
		
		String[] arr = names.stream().toArray(String[]::new);
		
		System.out.println(Arrays.toString(arr));
	}

}
