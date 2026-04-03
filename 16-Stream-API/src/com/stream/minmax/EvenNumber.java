package com.stream.minmax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EvenNumber {

	public static void main(String[] args) {
		
		List<Integer> num = Arrays.asList(13,12,67,46,35,80,6);
		
		int maxEven = num.stream()
				      .filter(n -> n % 2 == 0)
				      .max(Integer::compareTo).get();
				      
				      System.out.println(maxEven);
	}

}
