package com.stream.findfirst;

import java.util.Arrays;
import java.util.List;

public class StudentFind {
	
	    String name;
	    int marks;

	   StudentFind(String name, int marks) {
	        this.name = name;
	        this.marks = marks;
	    }
	
	public static void main(String[] args) {
		
	

	List<StudentFind> students = Arrays.asList(
	    new StudentFind("A", 35),
	    new StudentFind("B", 50),
	    new StudentFind("C", 20)
	);

	students.stream()
	        .filter(s -> s.marks >= 40)
	        .findFirst()
	        .ifPresent(s -> System.out.println(s.name));

}
}
