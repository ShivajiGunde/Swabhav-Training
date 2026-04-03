package com.monocept.model;

public class RegularCourses extends Course {

	private double labFee;

	public RegularCourses(int courseId, String courseName, double baseFee, double labFee) {
		super(courseId, courseName, baseFee);

		this.labFee = labFee;

	}

	@Override
	public double calculateFee() {

		if (baseFee < 0 || labFee < 0) {

			System.out.println("Lab fee cannot be negative");
			return labFee;
		}
		return baseFee + labFee;

	}

}
