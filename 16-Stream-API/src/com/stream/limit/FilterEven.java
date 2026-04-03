package com.stream.limit;

import java.util.Arrays;
import java.util.List;

public class FilterEven {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(27, 32, 12, 45, 77, 85, 10, 15);

		int sum = numbers.stream()
						 .filter(n -> n % 2 == 0)
						 .limit(4).mapToInt(Integer::intValue)
						 .sum();
		
		System.out.println(sum);
	}

}
