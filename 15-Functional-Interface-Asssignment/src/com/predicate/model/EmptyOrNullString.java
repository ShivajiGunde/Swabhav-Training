package com.predicate.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EmptyOrNullString {

	public static void main(String[] args) {

		Predicate<String> isValid = str -> str != null && !str.isEmpty();

		List<String> list = Arrays.asList("", "Java", "null", "");

		for (String str : list) {
			if (isValid.test(str)) {
				System.out.println(str);
			}
		}

	}

}
