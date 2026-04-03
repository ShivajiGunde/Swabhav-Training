package com.singleresponsibility.test;

import java.util.Scanner;

import com.singleresponsibility.model.InventoryManager;
import com.singleresponsibility.model.PriceCalculator;
import com.singleresponsibility.model.Product;
import com.singleresponsibility.model.ProductRenderer;
import com.singleresponsibility.model.ProductService;

public class ECommerseManagementSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// User input
		System.out.print("Enter product name: ");
		String name = sc.nextLine();

		System.out.print("Enter description: ");
		String desc = sc.nextLine();

		System.out.print("Enter base price: ");
		double price = sc.nextDouble();

		System.out.print("Enter discount (%): ");
		double discount = sc.nextDouble();

		System.out.print("Enter tax (%): ");
		double tax = sc.nextDouble();

		System.out.print("Enter stock: ");
		int stock = sc.nextInt();

		// Object creation
		Product product = new Product(name, desc, price);
		
		PriceCalculator calculator = new PriceCalculator();
		InventoryManager inventory = new InventoryManager(stock);
		ProductRenderer renderer = new ProductRenderer();

		ProductService service = new ProductService(calculator, inventory, renderer);

		// Business operations
		double finalPrice = service.getFinalPrice(product, discount, tax);

		System.out.println("\n--- Product Details ---");
		System.out.println(service.getProductDetails(product, finalPrice));

		System.out.print("\nEnter quantity to buy: ");
		int qty = sc.nextInt();

		try {
			service.purchaseProduct(qty);
			System.out.println("Purchase successful!");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Remaining stock: " + service.getRemainingStock());

		sc.close();
	}

}
