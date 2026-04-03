package com.stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentSortMain {
	public static void main(String[] args) {
		
		List<StudentSort> student = Arrays.asList(new StudentSort(101, "Mahesh", 60),
													new StudentSort(102, "Ganesh", 50),
													new StudentSort(103, "Lokesh", 90),
													new StudentSort(104, "Shivaji", 80));
		
		List<StudentSort> sortedStudents = student.stream()
												  .sorted(Comparator.comparing(StudentSort::getMarks))
												  .collect(Collectors.toList());
		
		System.out.println("Sorted Students: "+sortedStudents);
	}

	

}
