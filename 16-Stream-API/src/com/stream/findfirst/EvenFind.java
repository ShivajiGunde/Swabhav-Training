package com.stream.findfirst;

import java.util.Arrays;
import java.util.List;

public class EvenFind {
	
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,3,5,6,8);

		nums.stream()
		    .filter(n -> n % 2 == 0)
		    .findFirst()
		    .ifPresent(System.out::println);
	}

}
