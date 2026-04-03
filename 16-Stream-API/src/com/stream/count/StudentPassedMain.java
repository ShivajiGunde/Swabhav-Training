package com.stream.count;

import java.util.Arrays;
import java.util.List;

public class StudentPassedMain {

	public static void main(String[] args) {

		List<StudentCount> student = Arrays.asList(new StudentCount(101, "Mahesh", 40),
				new StudentCount(102, "Manik", 50), new StudentCount(103, "Vishnu", 30),
				new StudentCount(104, "Sushant",60));

		long passed = student.stream().filter(n -> n.marks >= 40).count();
		
		System.out.println("Passed Students: "+passed);

	}

}
