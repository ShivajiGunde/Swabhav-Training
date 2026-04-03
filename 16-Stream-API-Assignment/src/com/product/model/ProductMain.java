package com.product.model;
import java.util.*;

public class ProductMain {
	

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        List<Product> products = new ArrayList<>();

	        System.out.print("Enter number of products: ");
	        int n = sc.nextInt();
	        sc.nextLine();

	        // Input
	        for (int i = 0; i < n; i++) {
	            System.out.println("\nProduct " + (i + 1));

	            System.out.print("ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Name: ");
	            String name = sc.nextLine();

	            System.out.print("Category: ");
	            String category = sc.nextLine();

	            System.out.print("Price: ");
	            double price = sc.nextDouble();

	            System.out.print("Stock: ");
	            int stock = sc.nextInt();

	            System.out.print("Sold Units: ");
	            int sold = sc.nextInt();

	            products.add(new Product(id, name, category, price, stock, sold));
	        }

	        int choice;

	        do {
	            System.out.println("\n===== MENU =====");
	            System.out.println("1. Out of Stock Products");
	            System.out.println("2. Group by Category");
	            System.out.println("3. Total Stock Value");
	            System.out.println("4. Highest Sold Product");
	            System.out.println("5. Sort by Sold Units (Desc)");
	            System.out.println("6. Product Name -> Stock Map");
	            System.out.println("7. Check All In Stock");
	            System.out.println("0. Exit");

	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    ProductService.outOfStock(products);
	                    break;

	                case 2:
	                    ProductService.groupByCategory(products);
	                    break;

	                case 3:
	                    System.out.println("Total Stock Value: " +
	                            ProductService.totalStockValue(products));
	                    break;

	                case 4:
	                    ProductService.highestSold(products);
	                    break;

	                case 5:
	                    ProductService.sortBySoldDesc(products);
	                    break;

	                case 6:
	                    ProductService.nameToStockMap(products);
	                    break;

	                case 7:
	                    boolean result = ProductService.allInStock(products);
	                    System.out.println("All products in stock? " + result);
	                    break;

	                case 0:
	                    System.out.println("Exiting...");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 0);

	        sc.close();
	    }
	}


