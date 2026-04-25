package com.monocept.model;

public class Student {

	private int studentId;
	private String name;
	private int age;
	private int branchId;

	public Student(){}

	public Student(String name, int age, int branchId) {
		this.name = name;
		this.age = age;
		this.branchId = branchId;
	}

	
	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getBranchId() {
		return branchId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "Student [id=" + studentId + ", name=" + name + ", age=" + age + ", branchId=" + branchId + "]";
	}
}
