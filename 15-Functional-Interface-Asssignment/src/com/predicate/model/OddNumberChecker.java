package com.predicate.model;

import java.util.function.Predicate;

public class OddNumberChecker {
	public static void main(String[] args) {

		Predicate<Integer> isOdd = n -> n % 2 != 0;

		for (int i = 1; i <= 10; i++) {
			if (isOdd.test(i))
				System.out.println(i);
		}

	}

}
