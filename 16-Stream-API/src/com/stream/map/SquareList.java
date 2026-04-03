package com.stream.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquareList {
	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(2, 5, 34, 12, 3);

		List<Integer> square =  num.stream().map(n -> n * n).collect(Collectors.toList());

		System.out.println(square);
	}

}
