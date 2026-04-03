package com.stream.count;

import java.util.Arrays;
import java.util.List;

public class StudentCountMain {
	public static void main(String[] args) {
		
		List<StudentCount> sCount = Arrays.asList(new StudentCount(101, "Ganesh", 35),
												new StudentCount(102, "Ramesh", 50),
												new StudentCount(103, "Aman", 60));
		
		long passedStudents = sCount.stream().filter(s-> s.marks >= 40).count();
		
		System.out.println(passedStudents);
	}

}
