package com.monocept.model;

public class Registration {

	private int regId;
	private int studentId;
	private int courseId;
	public double feesPaid;

	public Registration(int studentId, int courseId, double feesPaid) {
		super();
		this.regId = regId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.feesPaid = feesPaid;
	}

	public int getRegId() {
		return regId;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public double getFeesPaid() {
		return feesPaid;
	}

	@Override
	public String toString() {
		return "Registration [reg_id=" + regId + ", student_id=" + studentId + ",courseId=" + courseId
				+ ", fees_paid=" + feesPaid + "]";
	}

}
