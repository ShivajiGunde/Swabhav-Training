package com.stream.map;

public class StudentGrace {

	int id;
	String name;
	int marks;

	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentGrace [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	public StudentGrace(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

}
