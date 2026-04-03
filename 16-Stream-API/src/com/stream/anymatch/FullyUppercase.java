package com.stream.anymatch;

import java.util.Arrays;
import java.util.List;

public class FullyUppercase {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("HELLO", "world", "JAVA");

		boolean result = words.stream().anyMatch(w -> w.equals(w.toUpperCase()));

		System.out.println(result);
	}

}
