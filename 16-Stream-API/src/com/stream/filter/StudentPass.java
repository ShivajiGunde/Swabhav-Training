package com.stream.filter;

public class StudentPass {

	int id;
	String name;
	int marks;

	public StudentPass(int id,String name,int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentPass [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

}
