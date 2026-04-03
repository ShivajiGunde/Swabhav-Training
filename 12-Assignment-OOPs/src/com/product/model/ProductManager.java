package com.product.model;

import java.util.Scanner;

public class ProductManager {
	private Scanner scanner;
	private Product[] product;
	
	public ProductManager(int n) {
		scanner = new Scanner(System.in);
		product = new Product[n];
	}
	
	 public void createProducts() {

	        for (int i = 0; i < product.length; i++) {
	            System.out.println("\nEnter details for product " + (i + 1));

	            int type = 0;
	            while (true) {
	                System.out.print("Select Product Type (1-Electronics, 2-Clothing): ");
	                type = scanner.nextInt();
	                scanner.nextLine();
	                
	                if (type == 1 || type == 2) break;
	                System.out.println("Invalid type. Enter 1 or 2.");
	            }

	            String name ="";;
	            double price=0.0;

	            while (true) {
	                try {
	                   
	                    System.out.print("Enter Product Name: ");
	                    name = scanner.nextLine();

	                    System.out.print("Enter Base Price: ");
	                    price = scanner.nextDouble();
	                    scanner.nextLine();

	                    if (type == 1) { 
	                        System.out.print("Enter warranty months: ");
	                        int warranty = scanner.nextInt();
	                        scanner.nextLine();
	                        
	                        product[i] = new Electronics(name, price, warranty);
	                        
	                    } else { 
	                        System.out.print("Enter size (S/M/L/XL): ");
	                        String size = scanner.nextLine();
	                        product[i] = new Clothing( name, price, size);
	                    }
	                    break; 
	                    
	                } catch (IllegalArgumentException e) {
	                    System.out.println("Error: " + e.getMessage());
	                }
	            }

	            System.out.println("Product added successfully!");
	        }
	    }

	    // Display all products
	    public void displayInventory() {
	        System.out.println("\n===== Product Details =====");
	        for (Product p : product) {
	             p.display();
	        }
	    }

	    public void closeScanner() {
	        scanner.close();
	    }
	}
	

