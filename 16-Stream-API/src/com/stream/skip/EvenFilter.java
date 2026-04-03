package com.stream.skip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenFilter {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(10, 23, 67, 43, 29, 20, 38);

		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).skip(2).collect(Collectors.toList());
		
		System.out.println(evenNumbers);
	}

}
