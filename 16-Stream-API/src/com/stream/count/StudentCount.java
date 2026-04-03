package com.stream.count;

public class StudentCount {

	int id;
	String name;
	int marks;

	@Override
	public String toString() {
		return "StudentCount [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	public StudentCount(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
}
