package com.monocept.model;

//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.Scanner;
//
public class Employee {

	synchronized void printTable(int n) {

		for (int i = 1; i < 3; i++) {

			System.out.println(n * i);
		}
	}

	public static void main(String[] args) {

		Employee e = new Employee();

		Thread t1 = new Thread(() -> {
			e.printTable(2);
		});
		Thread t2 = new Thread(() -> {
			e.printTable(5);
		});

//		
//		t.start();
//		t.run();
//		System.out.println("Main thread");

	}
//	private int id;
//	private String name;
//	private LocalDate dateOfJoining;
//
//	public Employee(int id, String name, LocalDate dateOfJoining) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.dateOfJoining = dateOfJoining;
//	}
//	
//	public String toString() {
//		return "Id: " + id + "Name: " + name + " " + dateOfJoining + " ";
//
//	}
//
//
//	class Developer extends Employee {
//
//		private int experiance;
//
//		public Developer(int id, String name, LocalDate dateOfJoining, int experiance) {
//			super(id, name, dateOfJoining);
//
//			this.experiance = experiance;
//		}
//
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		
//		Developer dev1 = new Developer(101,"Mayank",LocalDate.of(12, 01,2026));
//	}
//
}
