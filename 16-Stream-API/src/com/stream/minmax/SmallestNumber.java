package com.stream.minmax;

import java.util.Arrays;
import java.util.List;

public class SmallestNumber {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(14, 32, 13, 50, 60, 34, 53);

		int min = numbers.stream().min(Integer::compareTo).get();

		System.out.println(min);

	}

}
