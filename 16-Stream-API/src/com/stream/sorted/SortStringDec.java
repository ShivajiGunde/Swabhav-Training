package com.stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortStringDec {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("Mahesh", "Ganesh", "Aman", "Balaji", "Ram", "Laxman", "Mangesh");

		List<String> sorted = names.stream()
								   .sorted(Comparator.reverseOrder())
								   .collect(Collectors.toList());

		System.out.println("Z-A :" + sorted);
	}

}
