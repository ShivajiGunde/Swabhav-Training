package com.monocept.model;

public class OnlineQuize implements ExamEvaluator{

	private int marks;
	
	@Override
	public void evaluateMarks(int marks) {
		this.marks = marks;
	}

	public String calculateGrade() {
		if (marks >= 75)
			return "A";
		else if (marks >= 60)
			return "B";
		else if (marks >= 50)
			return "C";
		else
			return "Fail";
	}


}
