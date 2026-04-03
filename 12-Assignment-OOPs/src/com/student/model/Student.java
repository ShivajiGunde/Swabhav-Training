package com.student.model;

public class Student {

	private long studentId;
	private String name;
	private String course;

	public Student(long studentId, String name, String course) {
		super();
		this.studentId = generateStudentId();
		this.name = name;
		this.course = course;
	}

	public long getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	private long generateStudentId() {

		return System.currentTimeMillis();
	}

	public void display() {
		System.out.println("Student ID : " + studentId);
		System.out.println("Name : " + name);
		System.out.println("Course : " + course);
	}

}
