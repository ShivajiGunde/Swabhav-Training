package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.Product;

public class Main {
			
		    public static void main(String[] args) {
		    	
		    	Scanner scanner = new Scanner(System.in);
		    	
		    	System.out.println("Enter the product name");
		    	String productName = scanner.nextLine();
		    	
		    	System.out.println("Enter the price");
		    	double price = scanner.nextDouble();
		    	
		    	System.out.println("Enter the stockQuantity");
		    	int stockQuantity = scanner.nextInt();

		        Product product = new Product(productName, price, stockQuantity);
		        
		        boolean running = true;
		        
		        while (running) {
		            System.out.println("Choose an option:");
		            System.out.println("1. Increase Stock");
		            System.out.println("2. Reduce Stock");
		            System.out.println("3. Update Price (Admin)");
		            System.out.println("4. Discontinue Product");
		            System.out.println("5. Display Product Details");
		            System.out.println("6. Exit");

		            int choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.println("Enter quantity to increase:");
		                    int incQty = scanner.nextInt();
		                    product.increaseStock(incQty);
		                    break;

		                case 2:
		                    System.out.println("Enter quantity to reduce:");
		                    int redQty = scanner.nextInt();
		                    product.reduceStock(redQty);
		                    break;

		                case 3:
		                    System.out.println("Are you admin? (true/false):");
		                    boolean isAdmin = scanner.nextBoolean();
		                    System.out.println("Enter new price:");
		                    double newPrice = scanner.nextDouble();
		                    product.updatePrice(newPrice, isAdmin);
		                    break;

		                case 4:
		                    product.discontinueProduct();
		                    System.out.println("Product discontinued successfully.");
		                    break;

		                case 5:
		                    displayProductDetails(product);
		                    break;

		                case 6:
		                    running = false;
		                    System.out.println("Exiting program...");
		                    break;

		                default:
		                    System.out.println("Invalid choice. Try again.");
		            }
		        }

		
		
	}

			private static void displayProductDetails(Product product) {
			        System.out.println("\n--- PRODUCT DETAILS ---");
			        System.out.println("Product ID: " + product.getProductId());
			        System.out.println("Product Name: " + product.getProductName());
			        System.out.println("Price: " + product.getPrice());
			        System.out.println("Stock Quantity: " + product.getStockQuantity());
			        System.out.println("Discontinued: " + product.isDiscontinued());
			    }				
			}

