package com.stream.filter;

public class Student {
	int studentId;
	String name;
	int marks;

	Student(int studentId, String name, int marks) {
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Id: " + studentId + " Name: " + name + "Marks: " + marks;

	}

}
