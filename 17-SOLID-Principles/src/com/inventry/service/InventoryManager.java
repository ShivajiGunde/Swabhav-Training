package com.inventry.service;

import java.util.Scanner;

import com.inventry.model.Product;

public class InventoryManager {

	private InventoryService inventoryService;
	private Scanner scanner;

	public InventoryManager(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		while (true) {
			System.out.println("\n== Enter the choice ==");
			System.out.println("1. Add product");
			System.out.println("2. Remove stock");
			System.out.println("3. show inventory value");
			System.out.println("4. show all products");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				removeStock();
				break;
			case 3:
				inventoryService.printInventoryValue();
				break;
			case 4:
				inventoryService.showAllProducts();
				break;
			case 5:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private void addProduct() {
		while (true) {
			try {
				System.out.print("Enter product Id: ");
				int productId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter product name: ");
				String name = scanner.nextLine();

				System.out.print("Enter product quantity: ");
				int qty = scanner.nextInt();

				System.out.println("Enter reorder level: ");
				int reoderLevel = scanner.nextInt();

				System.out.println("Enter price: ");
				double price = scanner.nextDouble();

				scanner.nextLine();

				Product product = new Product(productId, name, qty, reoderLevel, price);
				inventoryService.addProduct(product);

				System.out.println("Product added successfully");
				break;
			} catch (IllegalArgumentException e) {

				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}

	private void removeStock() {
		while (true) {
			try {
				System.out.print("Enter product Id: ");
				int productId = scanner.nextInt();

				System.out.print("Enter quantity to remove: ");
				int qty = scanner.nextInt();
				scanner.nextLine();

				inventoryService.removeStock(productId, qty);

				System.out.println("Stock removed successfully");
				break;

			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}

}