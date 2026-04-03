package com.monocept.model;

public class Course {

	protected int courseId;
	public String courseName;
	protected double baseFee;

	private static int totalCourses = 0;

	public Course(int courseId, String courseName, double baseFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.baseFee = baseFee;

		totalCourses++;

	}

	public double calculateFee() {

		if (baseFee < 0) {

			System.out.println("Base fee cannot be negative");
		}
		return baseFee;
	}

	public double calculateTotalFee(double extraCharges) {

		if (baseFee < 0 || extraCharges < 0) {

			System.out.println("BaseFee cannot be negative");
		}
		return baseFee + extraCharges;

	}

	public static int getTotalCourses() {

		return totalCourses;
	}

	public int getCourseId() {
		
		return courseId;
	}

}
