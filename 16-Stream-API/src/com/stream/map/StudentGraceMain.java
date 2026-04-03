package com.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGraceMain {
	public static void main(String[] args) {
		
		List<StudentGrace> studentList = Arrays.asList(new StudentGrace(101, "Ramesh", 35),
												new StudentGrace(102,"Kamal",40),
												new StudentGrace(103, "Lokesh", 50));
		
		List<StudentGrace> updatedStudents = studentList.stream().map(s->{
            if (s.getMarks() < 40) {
                s.setMarks(s.getMarks() + 5);
            }
            return s;
        }).collect(Collectors.toList());
		
		updatedStudents.forEach(System.out::println);
			
		}
	}


