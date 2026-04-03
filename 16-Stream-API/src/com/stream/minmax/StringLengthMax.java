package com.stream.minmax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StringLengthMax {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Mahesh", "Manjunath", "Ram");

		Optional<String> maxLengthName = names.stream().max(Comparator.comparing(s -> s.length()));

		System.out.println(maxLengthName);
	}

}
