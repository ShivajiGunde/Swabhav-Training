package com.access.privates;

public class Student {
	private int id;
	private String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "Id: "+id+ "Name: "+name+" ";
	}
	
	public static void main(String[] args) {

		Student s = new Student(101, "Mahesh");
		
		System.out.println(s);
	}

}
