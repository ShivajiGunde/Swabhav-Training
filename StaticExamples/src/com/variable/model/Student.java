package com.variable.model;

public class Student {
	
	 int id;
	 String name;
	static String college = "ABC college";
	
	public Student(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public void display() {
		
		System.out.println("Id: "+ id + " Name: " + name +" College "+college+" ");
	}

}


