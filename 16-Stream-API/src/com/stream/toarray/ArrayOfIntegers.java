package com.stream.toarray;

import java.util.Arrays;

public class ArrayOfIntegers {
	
	public static void main(String[] args) {
		
		int[] arr = {23,11,42,34,12,10};
		
	         int sum = Arrays.stream(arr).sum();
	         
	         System.out.println("Sum: "+sum);
		
		
	}

}
