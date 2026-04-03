package com.monocept.model;

public class OnlineCourses extends Course {

	private double platformFee;

	public OnlineCourses(int courseId, String courseName, double baseFee, double platformFee) {
		super(courseId, courseName, baseFee);

		this.platformFee = platformFee;

	}

	@Override
	public double calculateFee() {

		if (baseFee < 0 || platformFee < 0) {
			System.out.println("basefee or platformfee  Cannot be negative");

			return platformFee;
		}
		return baseFee + platformFee;
	}

}
