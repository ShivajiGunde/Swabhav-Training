package com.stream.anymatch;

import java.util.Arrays;
import java.util.List;

public class AnyEvenNumber {
	
	public static void main(String[] args) {
		
	List<Integer> nums = Arrays.asList(1,3,5,7,8);

	boolean result = nums.stream()
	                     .anyMatch(n -> n % 2 == 0);

	System.out.println(result);
	}

}
