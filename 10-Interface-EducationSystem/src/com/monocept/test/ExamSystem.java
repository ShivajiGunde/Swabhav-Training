package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.ExamEvaluator;
import com.monocept.model.OnlineQuize;
import com.monocept.model.PracticalExam;
import com.monocept.model.TheoryExam;

public class ExamSystem {
	
	 public static void printResult(ExamEvaluator exam, int marks) {
	        exam.evaluateMarks(marks); 
	        System.out.println("Marks: " + marks);
	        System.out.println("Grade: " + exam.calculateGrade());
	    }

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        boolean running = true;
	        
	        while(running) {
	        System.out.println("\nSelect Exam Type:");
	        System.out.println("1. Theory Exam");
	        System.out.println("2. Practical Exam");
	        System.out.println("3. Online Quiz");
	        System.out.println("4. Exit");


	        System.out.print("Enter choice: ");
	        int choice = scanner.nextInt();

	        System.out.print("Enter marks: ");
	        int marks = scanner.nextInt();
	        
	        if(marks < 0) {
	        	System.out.println("Marks cannot be negative");
	        	continue;
	        }
	        
	        scanner.nextLine();

	        ExamEvaluator exam = null;   

	        switch (choice) {
	            case 1:
	                exam = new TheoryExam();
	                break;
	            case 2:
	                exam = new PracticalExam();
	                break;
	            case 3:
	                exam = new OnlineQuize();
	                break;
	                
	            case 4:
	            	running = false;
	            	continue;
	            default:
	                System.out.println("Invalid choice!");
	                continue;
	        }
	        
	        System.out.println("====Result=====");
	        printResult(exam, marks);
	        }
	        scanner.close();
	    }

}
