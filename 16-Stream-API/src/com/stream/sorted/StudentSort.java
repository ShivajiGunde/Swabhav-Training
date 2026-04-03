package com.stream.sorted;

public class StudentSort {

		int studentId;
		String name;
		int marks;

		StudentSort(int studentId, String name, int marks) {
			this.studentId = studentId;
			this.name = name;
			this.marks = marks;
		}
		
		public int getMarks() {
			return marks;
		}

		@Override
		public String toString() {
			return "Id: " + studentId + " Name: " + name + "Marks: " + marks;

		}

	}



