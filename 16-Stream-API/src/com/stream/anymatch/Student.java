package com.stream.anymatch;

import java.util.Arrays;
import java.util.List;

import com.stream.findfirst.StudentFind;

public class Student {

	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student("A", 35), new Student("B", 50), new Student("C", 20));

		boolean result = students.stream().anyMatch(s -> s.marks < 40);

		System.out.println(result);
	}

}
