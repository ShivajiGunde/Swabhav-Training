package com.stream.filter;

import java.util.*;
public class StudentMain {
	
	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList(new Student(101, "Ganesh", 50),
												new Student(102, "Ramesh", 80),
												new Student(103, "Harsh", 60),
												new Student(102, "Ankush", 90));
		
						 students.stream().filter( m -> m.marks >= 60)
								.forEach(System.out :: println);
		
	}

}
