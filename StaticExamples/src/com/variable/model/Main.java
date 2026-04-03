package com.variable.model;

public class Main {
	
		public static void main(String[] args) {
			
			Student v1 = new Student(1, "Mahesh");
			Student v2 = new Student(2, "Ganesh");
			
			v1.display();
			v2.display();
		}
	}


// static variable used for the common data for the every object
//output: shows common college name for every student
