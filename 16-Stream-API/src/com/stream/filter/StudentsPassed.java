package com.stream.filter;

import java.util.Arrays;
import java.util.List;

public class StudentsPassed {
	public static void main(String[] args) {
		
		List<StudentPass> student = Arrays.asList(new StudentPass(101, "Ramesh", 50),
												new StudentPass(102,"Ganesh",39),
												new StudentPass(103,"Atish",60));
		
		student.stream().filter(s->s.marks >= 40).forEach(System.out::println);
	}

}
