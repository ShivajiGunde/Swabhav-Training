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
				System.out.println("Exit");
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

				if (productId < 0) {
					throw new IllegalArgumentException("ProductId cannot be negative");
				}
				scanner.nextLine();

				System.out.print("Enter product name: ");
				String name = scanner.nextLine();

				if (name == null || !name.matches("^[A-Za-z ]{2,50}$")) {
					throw new IllegalArgumentException("Invalid product name Only letters allowed.");
				}

				System.out.print("Enter product quantity: ");
				int qty = scanner.nextInt();

				if (qty < 0) {
					throw new IllegalArgumentException("Quantity cannot be negative");
				}

				System.out.println("Enter reorder level: ");
				int reoderLevel = scanner.nextInt();

				if (reoderLevel < 0) {
					throw new IllegalArgumentException("Reorder level cannot be negative");
				}

				System.out.println("Enter price: ");
				double price = scanner.nextDouble();

				if (price < 0) {
					throw new IllegalArgumentException("Price cannot be negative");
				}

				scanner.nextLine();

				Product product = new Product(productId, name, qty, reoderLevel, price);
				inventoryService.addProduct(product);
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

				if (productId < 0) {
					throw new IllegalArgumentException("ProductId cannot be negative");
				}
				System.out.print("Enter quantity to remove: ");
				int qty = scanner.nextInt();

				if (qty < 0) {
					throw new IllegalArgumentException("Quantity cannot be negative");
				}

				scanner.nextLine();

				inventoryService.removeStock(productId, qty);
				break;

			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}

}