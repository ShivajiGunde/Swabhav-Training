package com.predicate.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StudentTest {

	public static void main(String[] args) {

		Predicate<Student> isPass = s -> s.marks >= 40;

		List<Student> list = Arrays.asList(new Student("Ganesh", 40), new Student("Ramesh", 30),
				new Student("Mahesh", 60), new Student("Arjun", 20));

		for (Student s : list) {
			if (isPass.test(s)) {

				System.out.println(s.name + "   " + s.marks);
			}
		}
	}
}
