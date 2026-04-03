package com.function.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StudentGrade {

	public static void main(String[] args) {

		Function<Integer, String> grades = marks -> {

			if (marks >= 75)
				return "A";
			else if (marks >= 50)
				return "B";
			else
				return "Fail";
		};

		List<Integer> marks = Arrays.asList(40, 50, 60, 70, 90);

		int studentNumber = 1;
		for (Integer mark : marks) {

			System.out.println("StudentNumber: " + studentNumber + " Marks: " + mark + " Grade: " + grades.apply(mark));
			studentNumber++;

		}
	}

}
