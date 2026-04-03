package com.student.model;

public class RegularStudent extends Student {

	private String attendance;

	public RegularStudent(long id, String name, String course, String attendance) {
		super(id, name, course);
		this.attendance = attendance;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Category : Regular");
		System.out.println("Attendance : " + attendance);
	}

}
