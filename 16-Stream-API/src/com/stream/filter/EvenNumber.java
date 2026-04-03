package com.stream.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EvenNumber {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 29, 13, 20, 35, 68, 42);

		 list.stream().filter(n -> n % 2 == 0).forEach(System.out :: println);
		

	}

}
