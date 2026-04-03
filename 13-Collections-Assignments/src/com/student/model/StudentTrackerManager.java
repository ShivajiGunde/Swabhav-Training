package com.student.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentTrackerManager {
	
		
	Set<Student> studentSet = new HashSet<>();
	
	// add students without dupplicates
			public boolean addStudent(Student student) {

				return studentSet.add(student);
			}

	// SortedBy Rank
	public List<Student> getRankedStudents() {

		List<Student> ranked = new ArrayList<Student>(studentSet);

		Collections.sort(ranked);

		return ranked;
	}

	// Sorted by Department
	public List<Student> sortStudentsByDepartment() {

		List<Student> sortedByDept = new ArrayList<>(studentSet);

		Collections.sort(sortedByDept, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {

				return s1.getDepartment().compareTo(s2.getDepartment());
			}
		});
		return sortedByDept;

	}

	public List<Student> sortByName() {

		List<Student> sortByName = new ArrayList<>(studentSet);
		
		//sortedByName.sort(Comparator.comparing(Student::sortByName));

		Collections.sort(sortByName, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		});
		return sortByName;
	}

	public void removeIneligible(double below) {
		Iterator<Student> it = studentSet.iterator();
		while (it.hasNext()) {
			Student s = it.next();
			if (s.getTotalMarks() < below) {
				System.out.println("Removing ineligible student: " + s.getName());
				it.remove();
			}
		}
	}
}
