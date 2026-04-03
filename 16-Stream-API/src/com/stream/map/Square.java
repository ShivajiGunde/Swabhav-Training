package com.stream.map;

import java.util.Arrays;
import java.util.List;

public class Square {
	public static void main(String[] args) {
		
		List<Integer> num = Arrays.asList(2,5,8,10);
		
		num.stream().map(n->n * n).forEach(System.out::println);
	}

}
