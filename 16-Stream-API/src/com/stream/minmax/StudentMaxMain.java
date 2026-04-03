package com.stream.minmax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentMaxMain {

	public static void main(String[] args) {

		List<StudentMax> student = Arrays.asList(new StudentMax(101, "Aman", 50), new StudentMax(104, "Sushant", 90),
				new StudentMax(102, "Ranjit", 40), new StudentMax(103, "Harsh", 80));

		Optional<StudentMax> highestMarks = Optional
				.of(student.stream()
						.max(Comparator.comparing(StudentMax::getMarks))
						.get());
		
		System.out.println(highestMarks);
	}
}
