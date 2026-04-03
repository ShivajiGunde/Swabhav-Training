package com.monocept.model;

import java.util.Scanner;

public class RiderChecker {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		        double totalBill = 0.0;
		        int age;
		        double height;
		        char wantPhotos;

		        System.out.print("Enter height in cm: ");
		        height = scanner.nextDouble();

		        if (height > 120) {
		            System.out.print("Enter age: ");
		            age = scanner.nextInt();

		            if (age < 12) {
		            	
		                totalBill += 5.0;
		            
		            } else if (age >= 12 && age < 18) {
		            
		            	totalBill += 7.0;
		            } else if (age >= 45 && age <= 55) {
		              
		            	totalBill += 0.0; // +$0
		            } 
		            else if (age >= 18) {
		               
		            	totalBill += 12.0;
		            }

		            System.out.print("Want photos? (Y/N): ");
		            wantPhotos = scanner.next().charAt(0);
		           
		            if (wantPhotos == 'Y' || wantPhotos == 'y') {
		               
		            	totalBill += 3.0;
		            }

		            System.out.println("Can ride.");
		        } else {
		            System.out.println("Can't ride.");
		        }
		        
		        scanner.close();
		        System.out.println("The total bill is $" + totalBill + ".");
		    }
		}


