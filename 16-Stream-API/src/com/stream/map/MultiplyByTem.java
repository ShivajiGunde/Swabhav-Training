package com.stream.map;

import java.util.Arrays;
import java.util.List;

public class MultiplyByTem {
	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(10, 20, 30, 40);

		num.stream().map(n -> n * 10).forEach(System.out::println);
	}

}
