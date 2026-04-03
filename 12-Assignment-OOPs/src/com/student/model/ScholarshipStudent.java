package com.student.model;

public class ScholarshipStudent extends Student {

	private double scholarshipAmount;

	public ScholarshipStudent(long studentId, String name, String course, double scholarshipAmount) {
		super(studentId, name, course);
		this.scholarshipAmount = scholarshipAmount;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Category : Scholarship");
		System.out.println("Scholarship Amount : " + scholarshipAmount);

	}

}
