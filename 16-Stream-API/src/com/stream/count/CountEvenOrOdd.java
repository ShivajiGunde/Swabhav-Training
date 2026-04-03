package com.stream.count;

import java.util.Arrays;
import java.util.List;

public class CountEvenOrOdd {

	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(12, 13, 14, 15, 16);

		long evenCount = num.stream().filter(n -> n % 2 == 0).count();

		long oddCount = num.stream().filter(n -> n % 2 != 0).count();
		
		System.out.println("Even Count " +evenCount);
		System.out.println("Odd count " +oddCount);
	}

}
