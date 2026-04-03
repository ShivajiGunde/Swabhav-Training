package com.student.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student implements Comparable<Student> {

	private int studentId;
	private String name;
	private String department;
	private Map<String, Integer> marks;

	public Student(int studentId, String name, String department) {
		super();

		if (studentId <= 0) {

			throw new IllegalArgumentException("Student id cannot be negative");
		}
		this.studentId = studentId;

		if (name.isEmpty() || !name.matches("[a-zA-Z]+")) {

			throw new IllegalArgumentException("Name cannot be null");
		}
		this.name = name;

		if (department.isEmpty() || !department.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		this.department = department;

		this.marks = new HashMap<>();
	}

	public int getStudentId() {

		return studentId;

	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public void addMark(String subject, int score) {
		try {
			if (score < 0) {
				throw new IllegalArgumentException("Marks cannot be negative!");
			}

			if (department.isEmpty() || !department.matches("[a-zA-Z]+")) {
				throw new IllegalArgumentException("Name cannot be null");
			}

			marks.put(subject, score);

		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public int getTotalMarks() {
		int total = 0;
		for (int score : marks.values()) {
			total += score;
		}
		return total;

	}

	public double getAverageMarks() {
		if (marks.size() == 0) {
			return 0;
		}
		return getTotalMarks() / marks.size();
	}

	// natural sorting by studentId
	@Override
	public int compareTo(Student s) {

		return Integer.compare(s.getTotalMarks(), this.getTotalMarks());
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", department=" + department + ", marks=" + marks
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		Student s = (Student) o;
		return studentId == s.studentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	public void display() {
		System.out.println("StudentId: " + studentId);
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Marks: " + marks);
	}

}