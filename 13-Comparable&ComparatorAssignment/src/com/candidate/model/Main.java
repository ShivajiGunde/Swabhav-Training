package com.candidate.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	 public static void main(String[] args) {

	        List<Candidate> list = new ArrayList<>();

	        list.add(new Candidate("Mahesh", 20));
	        list.add(new Candidate("Ramesh", 25));
	        list.add(new Candidate("Mahesh", 30));
	        list.add(new Candidate("Ankush", 27));

	        Collections.sort(list, new CandidateComparator());

	        for (Candidate c : list) {
	        	
	            System.out.println(c.name + " " + c.age);
	        }
	 }
}
